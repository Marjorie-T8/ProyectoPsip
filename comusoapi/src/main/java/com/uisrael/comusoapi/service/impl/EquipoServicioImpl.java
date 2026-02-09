package com.uisrael.comusoapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.EquipoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.EquipoResponseDTO;
import com.uisrael.comusoapi.service.IEquipoServicio;

import reactor.core.publisher.Mono;

@Service
public class EquipoServicioImpl implements IEquipoServicio {

    private final WebClient webClient;

    public EquipoServicioImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<EquipoResponseDTO> listarEquipos() {
        return webClient.get().uri("/equipo").retrieve().bodyToFlux(EquipoResponseDTO.class).collectList().block();
    }

    @Override
    public void crearEquipo(EquipoRequestDTO dto) {
        try {
            webClient.post()
                    .uri("/equipo")
                    .bodyValue(dto)
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        } catch (org.springframework.web.reactive.function.client.WebClientResponseException e) {
            
            System.err.println("DETALLE ERROR EQUIPO: " + e.getResponseBodyAsString());
            throw e;
        }
    }

    @Override
    public EquipoResponseDTO buscarEquipoPorId(int id) {
        return webClient.get()
                .uri("/equipo/{id}", id)
                .retrieve()
                .bodyToMono(EquipoResponseDTO.class)
                .block();
    }
 
    @Override
    public List<EquipoResponseDTO> listarEquiposPorCliente(int idCliente) {
      
        if (idCliente <= 0) {
            return java.util.Collections.emptyList();
        }
        
      
        return webClient.get()
                .uri("/equipo/cliente/{id}", idCliente) 
                .retrieve()
                   
                    .onStatus(status -> status.is4xxClientError(), response -> Mono.empty())
                .bodyToFlux(EquipoResponseDTO.class)
                .collectList()
                .block();
    }

	@Override
	public void eliminarEquipo(int id) {
	    webClient.delete()
	            .uri("/equipo/{id}", id)
	            .retrieve()
	            .toBodilessEntity()
	            .block();
	}
	@Override
	public void actualizarEquipo(int id, EquipoRequestDTO dto) {
	   
	    webClient.post() 
	            .uri("/equipo") 
	            .bodyValue(dto)
	            .retrieve()
	            .toBodilessEntity()
	            .block();
	}
    
}
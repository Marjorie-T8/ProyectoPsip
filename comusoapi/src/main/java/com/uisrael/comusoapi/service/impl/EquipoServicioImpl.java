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
    public EquipoResponseDTO crearEquipo(EquipoRequestDTO dto) {
        try {
            EquipoResponseDTO respuesta = webClient.post()
                    .uri("/equipo")
                    .bodyValue(dto)
                    .retrieve()
                    .onStatus(status -> status.isError(), response -> {
                        return response.bodyToMono(String.class)
                                .map(body -> new RuntimeException("Error en backend: " + response.statusCode() + " - " + body));
                    })
                    .bodyToMono(EquipoResponseDTO.class)
                    .block();
            // Log temporal para ver exactamente qué llega
            System.out.println("Respuesta del backend 8080:");
            System.out.println(" - Objeto completo: " + respuesta);
            if (respuesta != null) {
                System.out.println(" - idequipo recibido: " + respuesta.getIdequipo());
            } else {
                System.out.println(" - Respuesta fue NULL");
            }
            // Seguridad: si por alguna razón el ID no llegó, lanzamos excepción
            if (respuesta == null || respuesta.getIdequipo() <= 0) {
                throw new RuntimeException("El backend no devolvió un ID válido para el equipo");
            }
            return respuesta;
        } catch (Exception e) {
            System.err.println("Fallo al crear equipo: " + e.getMessage());
            e.printStackTrace();
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
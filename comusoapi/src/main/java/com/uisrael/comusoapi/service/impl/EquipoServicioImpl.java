package com.uisrael.comusoapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.EquipoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.EquipoResponseDTO;
import com.uisrael.comusoapi.service.IEquipoServicio;

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
                .uri(uriBuilder -> uriBuilder.path("/equipo").queryParam("id_equipo", "eq." + id).build())
                .retrieve().bodyToMono(EquipoResponseDTO.class).block();
    }

    @Override
    public List<EquipoResponseDTO> listarEquiposPorCliente(int idCliente) {
        // IMPORTANTE: Cambiamos "id_cliente" por "idCliente" (Exactamente como tu Entidad)
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/equipo")
                    .queryParam("idCliente", "eq." + idCliente) 
                    .build())
                .retrieve()
                .bodyToFlux(EquipoResponseDTO.class)
                .collectList()
                .block();
    }
}
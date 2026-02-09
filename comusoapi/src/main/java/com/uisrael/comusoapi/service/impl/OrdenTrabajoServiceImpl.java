package com.uisrael.comusoapi.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.OrdenTrabajoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.OrdenTrabajoResponseDTO;
import com.uisrael.comusoapi.service.IOrdenTrabajoServicio;

@Service
public class OrdenTrabajoServiceImpl implements IOrdenTrabajoServicio {

    private final WebClient webClient;

    public OrdenTrabajoServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<OrdenTrabajoResponseDTO> listarOrdenesTrabajo() {
        return webClient.get()
                .uri("/ordentrabajo")
                .retrieve()
                .bodyToFlux(OrdenTrabajoResponseDTO.class)
                .collectList()
                .block();
    }

    @Override
    public void crearOrdenTrabajo(OrdenTrabajoRequestDTO dto) {
        dto.setFechaSolicitud(LocalDate.now());
        dto.setEstado("PENDIENTE");
        
        webClient.post()
                .uri("/ordentrabajo") 
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void eliminarOrdenTrabajo(int id) {
        webClient.delete()
                .uri("/ordentrabajo/" + id) 
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void actualizarOrdenTrabajo(OrdenTrabajoRequestDTO dto) {
        
        webClient.put()
                .uri("/ordentrabajo/actualizar")
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public OrdenTrabajoResponseDTO buscarOrdenTrabajoPorId(int id) {
        return webClient.get()
                .uri("/ordentrabajo/{id}", id) // Llama al código de atrás (8080)
                .retrieve()
                .bodyToMono(OrdenTrabajoResponseDTO.class)
                .block();
    }

   
}
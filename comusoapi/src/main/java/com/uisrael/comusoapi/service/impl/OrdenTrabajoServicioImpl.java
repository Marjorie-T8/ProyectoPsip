package com.uisrael.comusoapi.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.OrdenTrabajoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.OrdenTrabajoResponseDTO;
import com.uisrael.comusoapi.service.IOrdenTrabajoServicio;

@Service
public class OrdenTrabajoServicioImpl implements IOrdenTrabajoServicio {

    private final WebClient webClient;

    public OrdenTrabajoServicioImpl(WebClient webClient) {
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
   
        dto.setFechacreacion(LocalDate.now()); 
        dto.setEstado("PENDIENTE");
    
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
                .uri("/ordentrabajo/{id}", id)
                .retrieve()
                .bodyToMono(OrdenTrabajoResponseDTO.class)
                .block();
    }

   
}
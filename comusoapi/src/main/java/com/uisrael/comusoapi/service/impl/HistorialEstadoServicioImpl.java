package com.uisrael.comusoapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.HistorialEstadoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.HistorialEstadoResponseDTO;
import com.uisrael.comusoapi.service.IHistorialEstadoServicio;

@Service
public class HistorialEstadoServicioImpl implements IHistorialEstadoServicio {

    private final WebClient webClient;

    public HistorialEstadoServicioImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<HistorialEstadoResponseDTO> listarHistorial() {
        return webClient.get()
                .uri("/api/historialestado")
                .retrieve()
                .bodyToFlux(HistorialEstadoResponseDTO.class)
                .collectList()
                .block();
    }

    @Override
    public HistorialEstadoResponseDTO buscarHistorialPorId(int id) {
        return webClient.get()
                .uri("/api/historialestado/{id}", id)
                .retrieve()
                .bodyToMono(HistorialEstadoResponseDTO.class)
                .block();
    }

    @Override
    public HistorialEstadoResponseDTO crearHistorial(HistorialEstadoRequestDTO dto) {
        return webClient.post()
                .uri("/api/historialestado")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(HistorialEstadoResponseDTO.class)
                .block();
    }

    @Override
    public void actualizarHistorial(int id, HistorialEstadoRequestDTO dto) {
        webClient.put()
                .uri("/api/historialestado/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void eliminarHistorial(int id) {
        webClient.delete()
                .uri("/api/historialestado/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public List<HistorialEstadoResponseDTO> listarHistorialPorOrden(int idOrden) {
        return webClient.get()
                .uri("/api/historialestado/orden/{idOrden}", idOrden)
                .retrieve()
                .bodyToFlux(HistorialEstadoResponseDTO.class)
                .collectList()
                .block();
    }

    @Override
    public HistorialEstadoResponseDTO obtenerUltimoHistorialPorOrden(int idOrden) {
        return webClient.get()
                .uri("/api/historialestado/orden/{idOrden}/ultimo", idOrden)
                .retrieve()
                .bodyToMono(HistorialEstadoResponseDTO.class)
                .block();
    }
}
package com.uisrael.comusoapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.FotoVerificacionRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.FotoVerificacionResponseDTO;
import com.uisrael.comusoapi.service.IFotoVerificacionServicio;

@Service
public class FotoVerificacionServicioImpl implements IFotoVerificacionServicio {

    private final WebClient webClient;

    public FotoVerificacionServicioImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<FotoVerificacionResponseDTO> listarFotos() {
        return webClient.get()
                .uri("/api/fotoverificacion")
                .retrieve()
                .bodyToFlux(FotoVerificacionResponseDTO.class)
                .collectList()
                .block();
    }

    @Override
    public FotoVerificacionResponseDTO buscarFotoPorId(int id) {
        return webClient.get()
                .uri("/api/fotoverificacion/{id}", id)
                .retrieve()
                .bodyToMono(FotoVerificacionResponseDTO.class)
                .block();
    }

    @Override
    public FotoVerificacionResponseDTO crearFoto(FotoVerificacionRequestDTO dto) {
        return webClient.post()
                .uri("/api/fotoverificacion")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(FotoVerificacionResponseDTO.class)
                .block();
    }

    @Override
    public void actualizarFoto(int id, FotoVerificacionRequestDTO dto) {
        webClient.put()
                .uri("/api/fotoverificacion/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void eliminarFoto(int id) {
        webClient.delete()
                .uri("/api/fotoverificacion/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public List<FotoVerificacionResponseDTO> listarFotosPorOrden(int idOrden) {
        return webClient.get()
                .uri("/api/fotoverificacion/orden/{idOrden}", idOrden)
                .retrieve()
                .bodyToFlux(FotoVerificacionResponseDTO.class)
                .collectList()
                .block();
    }
}
package com.uisrael.comusoapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.MensajeClienteRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.MensajeClienteResponseDTO;
import com.uisrael.comusoapi.service.IMensajeClienteServicio;

@Service
public class MensajeClienteServicioImpl implements IMensajeClienteServicio {

    private final WebClient webClient;

    public MensajeClienteServicioImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<MensajeClienteResponseDTO> listarMensajes() {
        return webClient.get()
                .uri("/api/mensajeciente")
                .retrieve()
                .bodyToFlux(MensajeClienteResponseDTO.class)
                .collectList()
                .block();
    }

    @Override
    public MensajeClienteResponseDTO buscarMensajePorId(int id) {
        return webClient.get()
                .uri("/api/mensajeciente/{id}", id)
                .retrieve()
                .bodyToMono(MensajeClienteResponseDTO.class)
                .block();
    }

    @Override
    public MensajeClienteResponseDTO crearMensaje(MensajeClienteRequestDTO dto) {
        return webClient.post()
                .uri("/api/mensajeciente")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(MensajeClienteResponseDTO.class)
                .block();
    }

    @Override
    public void actualizarMensaje(int id, MensajeClienteRequestDTO dto) {
        webClient.put()
                .uri("/api/mensajeciente/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void eliminarMensaje(int id) {
        webClient.delete()
                .uri("/api/mensajeciente/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public List<MensajeClienteResponseDTO> listarMensajesPorOrden(int idOrden) {
        return webClient.get()
                .uri("/api/mensajeciente/orden/{idOrden}", idOrden)
                .retrieve()
                .bodyToFlux(MensajeClienteResponseDTO.class)
                .collectList()
                .block();
    }
}
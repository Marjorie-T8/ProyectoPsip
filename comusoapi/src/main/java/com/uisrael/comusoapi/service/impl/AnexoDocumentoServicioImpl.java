package com.uisrael.comusoapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.AnexoDocumentoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.AnexoDocumentoResponseDTO;
import com.uisrael.comusoapi.service.IAnexoDocumentosServicio;

@Service
public class AnexoDocumentoServicioImpl implements IAnexoDocumentosServicio {

    private final WebClient webClient;

    public AnexoDocumentoServicioImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<AnexoDocumentoResponseDTO> listarAnexos() {
        return webClient.get()
                .uri("/api/anexodocumentos")
                .retrieve()
                .bodyToFlux(AnexoDocumentoResponseDTO.class)
                .collectList()
                .block();
    }

    @Override
    public AnexoDocumentoResponseDTO buscarAnexoPorId(int id) {
        return webClient.get()
                .uri("/api/anexodocumentos/{id}", id)
                .retrieve()
                .bodyToMono(AnexoDocumentoResponseDTO.class)
                .block();
    }

    @Override
    public AnexoDocumentoResponseDTO crearAnexo(AnexoDocumentoRequestDTO dto) {
        return webClient.post()
                .uri("/api/anexodocumentos")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(AnexoDocumentoResponseDTO.class)
                .block();
    }

    @Override
    public void actualizarAnexo(int id, AnexoDocumentoRequestDTO dto) {
        webClient.put()
                .uri("/api/anexodocumentos/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void eliminarAnexo(int id) {
        webClient.delete()
                .uri("/api/anexodocumentos/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public List<AnexoDocumentoResponseDTO> listarAnexosPorOrden(int idOrden) {
        return webClient.get()
                .uri("/api/anexodocumentos/orden/{idOrden}", idOrden)
                .retrieve()
                .bodyToFlux(AnexoDocumentoResponseDTO.class)
                .collectList()
                .block();
    }
}
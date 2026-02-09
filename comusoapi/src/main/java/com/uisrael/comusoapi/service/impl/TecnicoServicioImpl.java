package com.uisrael.comusoapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.TecnicoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.TecnicoResponseDTO;
import com.uisrael.comusoapi.service.ITecnicoServicio;
@Service

public class TecnicoServicioImpl  implements ITecnicoServicio{

	private final WebClient webClient;

    public TecnicoServicioImpl(WebClient webClient) {
        this.webClient = webClient;
    }

 
    @Override
    public void crearTecnico(TecnicoRequestDTO dto) {
        webClient.post()
                .uri("/tecnico") 
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public TecnicoResponseDTO buscarTecnicoPorId(int id) {
        return webClient.get()
                .uri("/tecnico/{id}", id)
                .retrieve()
                .bodyToMono(TecnicoResponseDTO.class)
                .block();
    }

    @Override
    public void actualizarTecnico(TecnicoRequestDTO dto) {
        webClient.put()
                .uri("/tecnico/{id}", dto.getIdTecnico())
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void eliminarTecnico(int id) {
        webClient.delete()
                .uri("/tecnico/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
    @Override
    public List<TecnicoResponseDTO> listarTecnico() {
        return webClient.get()
                .uri("/tecnico") 
                .retrieve()
                .bodyToFlux(TecnicoResponseDTO.class)
                .collectList()
                .block();
    }
}

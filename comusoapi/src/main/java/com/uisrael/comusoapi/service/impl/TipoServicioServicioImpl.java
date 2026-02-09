package com.uisrael.comusoapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.comusoapi.modelo.dto.request.TipoServicioRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.TipoServicioResponseDTO;
import com.uisrael.comusoapi.service.ITipoServicioServicio;
@Service
public class TipoServicioServicioImpl implements ITipoServicioServicio{

	 private final WebClient webClient;

	    public TipoServicioServicioImpl(WebClient webClient) {
	        this.webClient = webClient;
	    }

	    @Override
	    public List<TipoServicioResponseDTO> listarTipoServicio() { 
	        return webClient.get()
	                .uri("/tiposervicio") 
	                .retrieve()
	                .bodyToFlux(TipoServicioResponseDTO.class)
	                .collectList()
	                .block();
	    }
	    @Override
	    public void crearTipoServicio(TipoServicioRequestDTO dto) {
	        webClient.post()
	                .uri("/tiposervicio/nuevo")
	                .bodyValue(dto)
	                .retrieve()
	                .toBodilessEntity()
	                .block();
	    }

	    @Override
	    public TipoServicioResponseDTO buscarTipoServicioPorId(int id) {
	        return webClient.get()
	                .uri("/tiposervicio/{id}", id)
	                .retrieve()
	                .bodyToMono(TipoServicioResponseDTO.class)
	                .block();
	    }

	
	    
}

package com.uisrael.comusoapi.service.impl;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import com.uisrael.comusoapi.modelo.dto.request.ClienteRequestDTO;

import com.uisrael.comusoapi.modelo.dto.response.ClienteResponseDTO;
import com.uisrael.comusoapi.service.IClienteServicio;


@Service

public class ClienteServicioImpl implements IClienteServicio{
	
	private final WebClient clienteWeb;

    public ClienteServicioImpl(WebClient clienteWeb) {
        this.clienteWeb = clienteWeb;
    }

    @Override
    public List<ClienteResponseDTO> listarCliente() {
        return clienteWeb.get()
                .uri("/cliente")
                .retrieve()
                .bodyToFlux(ClienteResponseDTO.class)
                .collectList()
                .block();
    }

    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDTO dto) {
        // Sin try-catch para que la excepción "explote" en el controlador
        return clienteWeb.post()
                .uri("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(ClienteResponseDTO.class)
                .block();
    }
    
    public ClienteResponseDTO buscarClientePorId(int id) { 
        return clienteWeb.get()
                .uri("/cliente/{id}", id)
                .retrieve()
                .bodyToMono(ClienteResponseDTO.class)
                .block();
    }

    @Override
    public void actualizarCliente(int id, ClienteRequestDTO dto) {
        clienteWeb.put()
                .uri("/cliente/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }



    @Override
    public void eliminarCliente(int id) {
        clienteWeb.delete()
                .uri("/cliente/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
    
}
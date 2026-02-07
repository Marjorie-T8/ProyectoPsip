package com.uisrael.comusoapi.service.impl;

import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;



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
        // Si tiene ID, es una actualización
        if (dto.getIdcliente() != null && dto.getIdcliente() > 0) {
            actualizarCliente(dto.getIdcliente(), dto);
            return buscarClientePorId(dto.getIdcliente()); 
        }

        // Si no tiene ID, es creación pura (POST)
        try {
            return clienteWeb.post()
                    .uri("/cliente")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(dto)
                    .retrieve()
                    // Si la API responde bien, nos devuelve el Cliente con su nuevo ID
                    .bodyToMono(ClienteResponseDTO.class)
                    .block(); // Bloqueamos para obtener el resultado síncrono
        } catch (Exception e) {
            System.err.println("Error al consumir API de cliente: " + e.getMessage());
            return null;
        }
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
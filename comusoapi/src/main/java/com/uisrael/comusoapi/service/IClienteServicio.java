package com.uisrael.comusoapi.service;

import java.util.List;

import com.uisrael.comusoapi.modelo.dto.request.ClienteRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.ClienteResponseDTO;

public interface IClienteServicio {

    List<ClienteResponseDTO> listarCliente();

    ClienteResponseDTO crearCliente(ClienteRequestDTO clienteDto);

    ClienteResponseDTO buscarClientePorId(int id);

    void actualizarCliente(int id, ClienteRequestDTO dto);  

    void eliminarCliente(int id);
}

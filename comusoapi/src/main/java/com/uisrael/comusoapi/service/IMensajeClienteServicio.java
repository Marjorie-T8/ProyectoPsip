package com.uisrael.comusoapi.service;

import java.util.List;

import com.uisrael.comusoapi.modelo.dto.request.MensajeClienteRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.MensajeClienteResponseDTO;

public interface IMensajeClienteServicio {

    List<MensajeClienteResponseDTO> listarMensajes();

    MensajeClienteResponseDTO buscarMensajePorId(int id);

    MensajeClienteResponseDTO crearMensaje(MensajeClienteRequestDTO dto);

    void actualizarMensaje(int id, MensajeClienteRequestDTO dto);

    void eliminarMensaje(int id);

    List<MensajeClienteResponseDTO> listarMensajesPorOrden(int idOrden);
}
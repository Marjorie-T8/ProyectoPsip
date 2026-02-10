package com.uisrael.comusoapi.service;

import java.util.List;

import com.uisrael.comusoapi.modelo.dto.request.HistorialEstadoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.HistorialEstadoResponseDTO;

public interface IHistorialEstadoServicio {

    List<HistorialEstadoResponseDTO> listarHistorial();

    HistorialEstadoResponseDTO buscarHistorialPorId(int id);

    HistorialEstadoResponseDTO crearHistorial(HistorialEstadoRequestDTO dto);

    void actualizarHistorial(int id, HistorialEstadoRequestDTO dto);

    void eliminarHistorial(int id);

    List<HistorialEstadoResponseDTO> listarHistorialPorOrden(int idOrden);

    HistorialEstadoResponseDTO obtenerUltimoHistorialPorOrden(int idOrden);
}
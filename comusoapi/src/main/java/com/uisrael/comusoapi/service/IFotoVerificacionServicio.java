package com.uisrael.comusoapi.service;

import java.util.List;

import com.uisrael.comusoapi.modelo.dto.request.FotoVerificacionRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.FotoVerificacionResponseDTO;

public interface IFotoVerificacionServicio {

    List<FotoVerificacionResponseDTO> listarFotos();

    FotoVerificacionResponseDTO buscarFotoPorId(int id);

    FotoVerificacionResponseDTO crearFoto(FotoVerificacionRequestDTO dto);

    void actualizarFoto(int id, FotoVerificacionRequestDTO dto);

    void eliminarFoto(int id);

    List<FotoVerificacionResponseDTO> listarFotosPorOrden(int idOrden);
}
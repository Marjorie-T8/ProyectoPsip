package com.uisrael.comusoapi.service;

import java.util.List;

import com.uisrael.comusoapi.modelo.dto.request.AnexoDocumentoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.AnexoDocumentoResponseDTO;

public interface IAnexoDocumentosServicio {

    List<AnexoDocumentoResponseDTO> listarAnexos();

    AnexoDocumentoResponseDTO buscarAnexoPorId(int id);

    AnexoDocumentoResponseDTO crearAnexo(AnexoDocumentoRequestDTO dto);

    void actualizarAnexo(int id, AnexoDocumentoRequestDTO dto);

    void eliminarAnexo(int id);

    List<AnexoDocumentoResponseDTO> listarAnexosPorOrden(int idOrden);
}
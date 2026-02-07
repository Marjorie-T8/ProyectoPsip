package com.uisrael.comusoapi.service;

import java.util.List;

import com.uisrael.comusoapi.modelo.dto.request.EquipoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.EquipoResponseDTO;

public interface IEquipoServicio {
    public List<EquipoResponseDTO> listarEquipos();

    public EquipoResponseDTO crearEquipo(EquipoRequestDTO dto); 
    public EquipoResponseDTO buscarEquipoPorId(int id);
    public List<EquipoResponseDTO> listarEquiposPorCliente(int idCliente);
    void actualizarEquipo(int id, EquipoRequestDTO dto);
    void eliminarEquipo(int id);
}
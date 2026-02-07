package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.HistorialEstado;
import com.uisrael.apipsip.presentacion.dto.request.HistorialEstadoRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.HistorialEstadoResponseDTO;

@Mapper(componentModel = "spring")
public interface IHistorialEstadoDtoMapper {
    HistorialEstado toDomain(HistorialEstadoRequestDTO dto);
    HistorialEstadoResponseDTO toResponseDto(HistorialEstado historialEstado);
}
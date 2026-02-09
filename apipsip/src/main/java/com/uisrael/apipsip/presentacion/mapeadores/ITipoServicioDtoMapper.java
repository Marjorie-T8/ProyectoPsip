package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.TipoServicio;
import com.uisrael.apipsip.presentacion.dto.request.TipoServicioRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.TipoServicioResponseDTO;

@Mapper(componentModel = "spring")
public interface ITipoServicioDtoMapper {
    TipoServicio toDomain(TipoServicioRequestDTO dto);
    TipoServicioResponseDTO toResponseDto(TipoServicio tipoServicio);
}
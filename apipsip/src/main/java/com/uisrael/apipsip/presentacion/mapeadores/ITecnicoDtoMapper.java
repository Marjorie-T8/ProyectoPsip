package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.Tecnico;
import com.uisrael.apipsip.presentacion.dto.request.TecnicoRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.TecnicoResponseDTO;

@Mapper(componentModel = "spring")
public interface ITecnicoDtoMapper {
    Tecnico toDomain(TecnicoRequestDTO dto);
    TecnicoResponseDTO toResponseDto(Tecnico tecnico);
}
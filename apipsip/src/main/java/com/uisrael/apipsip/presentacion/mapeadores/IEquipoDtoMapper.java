package com.uisrael.apipsip.presentacion.mapeadores;


import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.Equipo;
import com.uisrael.apipsip.presentacion.dto.request.EquipoRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.EquipoResponseDTO;

@Mapper(componentModel = "spring")
public interface IEquipoDtoMapper {
    Equipo toDomain(EquipoRequestDTO dto);
    EquipoResponseDTO toResponseDto(Equipo equipo);
}

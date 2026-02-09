package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.OrdenTrabajo;
import com.uisrael.apipsip.presentacion.dto.request.OrdenTrabajoRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.OrdenTrabajoResponseDTO;

@Mapper(componentModel = "spring")
public interface IOrdenTrabajoDtoMapper {
    OrdenTrabajo toDomain(OrdenTrabajoRequestDTO dto);
    OrdenTrabajoResponseDTO toResponseDto(OrdenTrabajo ordenTrabajo);
}
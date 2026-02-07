package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.PaginaWeb;
import com.uisrael.apipsip.presentacion.dto.request.PaginaWebRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.PaginaWebResponseDTO;

@Mapper(componentModel = "spring")
public interface IPaginaWebDtoMapper {
    PaginaWeb toDomain(PaginaWebRequestDTO dto);
    PaginaWebResponseDTO toResponseDto(PaginaWeb paginaWeb);
}
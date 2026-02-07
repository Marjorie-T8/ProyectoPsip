package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.AnexoDocumentos;
import com.uisrael.apipsip.presentacion.dto.request.AnexoDocumentosRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.AnexoDocumentosResponseDTO;

@Mapper(componentModel = "spring")
public interface IAnexoDocumentosDtoMapper {
    AnexoDocumentos toDomain(AnexoDocumentosRequestDTO dto);
    AnexoDocumentosResponseDTO toResponseDto(AnexoDocumentos anexoDocumentos);
}
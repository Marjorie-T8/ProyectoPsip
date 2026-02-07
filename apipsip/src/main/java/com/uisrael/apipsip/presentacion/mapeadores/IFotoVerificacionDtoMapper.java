package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.FotoVerificacion;
import com.uisrael.apipsip.presentacion.dto.request.FotoVerificacionRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.FotoVerificacionResponseDTO;

@Mapper(componentModel = "spring")
public interface IFotoVerificacionDtoMapper {
    FotoVerificacion toDomain(FotoVerificacionRequestDTO dto);
    FotoVerificacionResponseDTO toResponseDto(FotoVerificacion fotoVerificacion);
}
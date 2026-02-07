package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.apipsip.dominio.entidades.SolicitudServicio;
import com.uisrael.apipsip.presentacion.dto.request.SolicitudServicioRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.SolicitudServicioResponseDTO;

@Mapper(componentModel = "spring")
public interface ISolicitudServicioDtoMapper {

    
    SolicitudServicio toDomain(SolicitudServicioRequestDTO dto);
    SolicitudServicioResponseDTO toResponseDto(SolicitudServicio solicitudServicio);
}
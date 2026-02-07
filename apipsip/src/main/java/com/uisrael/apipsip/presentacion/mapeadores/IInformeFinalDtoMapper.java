package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.InformeFinal;
import com.uisrael.apipsip.presentacion.dto.request.InformeFinalRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.InformeFinalResponseDTO;

@Mapper(componentModel = "spring")
public interface IInformeFinalDtoMapper {

    
    InformeFinal toDomain(InformeFinalRequestDTO dto);
    InformeFinalResponseDTO toResponseDto(InformeFinal informeFinal);
}
package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.MensajeCliente;
import com.uisrael.apipsip.presentacion.dto.request.MensajeClienteRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.MensajeClienteResponseDTO;

@Mapper(componentModel = "spring")
public interface IMensajeClienteDtoMapper {
    MensajeCliente toDomain(MensajeClienteRequestDTO dto);
    MensajeClienteResponseDTO toResponseDto(MensajeCliente mensajeCliente);
}
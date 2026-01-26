package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.Cliente;
import com.uisrael.apipsip.presentacion.dto.request.ClienteRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.ClienteResponseDTO;

@Mapper (componentModel = "spring")
public interface IClienteDtoMapper {
	Cliente toDomain(ClienteRequestDTO dto);
	ClienteResponseDTO toResponseDto(Cliente cliente);

}

package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.Cliente;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.ClienteJpa;

@Mapper (componentModel = "spring")
public interface IClienteJpaMapper {
	Cliente toDomain(ClienteJpa entity);
	ClienteJpa toEntity(Cliente cliente);

}

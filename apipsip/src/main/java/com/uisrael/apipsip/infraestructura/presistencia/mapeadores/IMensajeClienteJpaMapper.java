package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.MensajeCliente;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.MensajeClienteJpa;

@Mapper(componentModel = "spring")
public interface IMensajeClienteJpaMapper {
	MensajeCliente toDomain(MensajeClienteJpa entity);
	MensajeClienteJpa toEntity(MensajeCliente mensajecliente);
}
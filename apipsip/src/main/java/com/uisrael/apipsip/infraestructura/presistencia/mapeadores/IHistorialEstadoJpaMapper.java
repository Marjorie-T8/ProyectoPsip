package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.HistorialEstado;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.HistorialEstadoJpa;

@Mapper(componentModel = "spring")
public interface IHistorialEstadoJpaMapper {
	HistorialEstado toDomain(HistorialEstadoJpa entity);
	HistorialEstadoJpa toEntity(HistorialEstado historialestado);
}
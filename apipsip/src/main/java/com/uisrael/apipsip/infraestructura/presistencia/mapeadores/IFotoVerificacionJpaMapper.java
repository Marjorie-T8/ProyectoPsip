package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.FotoVerificacion;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.FotoVerificacionJpa;

@Mapper(componentModel = "spring")
public interface IFotoVerificacionJpaMapper {
	FotoVerificacion toDomain(FotoVerificacionJpa entity);
	FotoVerificacionJpa toEntity(FotoVerificacion fotoverificacion);
}
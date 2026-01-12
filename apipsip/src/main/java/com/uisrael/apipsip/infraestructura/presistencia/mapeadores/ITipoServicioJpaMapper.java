package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;


import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.TipoServicio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.TipoServicioJpa;

@Mapper  (componentModel = "spring")
public interface ITipoServicioJpaMapper {
	TipoServicio toDomain(TipoServicioJpa entity);
	TipoServicioJpa toEntity(TipoServicio tiposervicio);

}


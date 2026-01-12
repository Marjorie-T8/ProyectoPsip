package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;


import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.OrdenTrabajo;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.OrdenTrabajoJpa;

@Mapper (componentModel = "spring")
public interface IOrdenTrabajoJpaMapper {
	OrdenTrabajo toDomain(OrdenTrabajoJpa entity);
	OrdenTrabajoJpa toEntity(OrdenTrabajo ordentrabajo);

}


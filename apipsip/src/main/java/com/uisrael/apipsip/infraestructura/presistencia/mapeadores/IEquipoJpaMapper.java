package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.apipsip.dominio.entidades.Equipo;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.EquipoJpa;

@Mapper (componentModel = "spring")
public interface IEquipoJpaMapper {
	  @Mapping(source = "idequipo", target = "idequipo")
	Equipo toDomain(EquipoJpa entity);

	EquipoJpa toEntity(Equipo equipo);

}

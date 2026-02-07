package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.PaginaWeb;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.PaginaWebJpa;

@Mapper(componentModel = "spring")
public interface IPaginaWebJpaMapper {
	PaginaWeb toDomain(PaginaWebJpa entity);
	PaginaWebJpa toEntity(PaginaWeb paginaweb);
}
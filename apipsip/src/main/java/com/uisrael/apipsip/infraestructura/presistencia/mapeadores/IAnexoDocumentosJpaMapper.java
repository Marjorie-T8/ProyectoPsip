package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.apipsip.dominio.entidades.AnexoDocumentos;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.AnexoDocumentosJpa;

@Mapper(componentModel = "spring")
public interface IAnexoDocumentosJpaMapper {
	AnexoDocumentos toDomain(AnexoDocumentosJpa entity);
	AnexoDocumentosJpa toEntity(AnexoDocumentos anexodocumentos);
}
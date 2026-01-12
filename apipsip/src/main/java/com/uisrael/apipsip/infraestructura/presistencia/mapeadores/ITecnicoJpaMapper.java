package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;


import org.mapstruct.Mapper;
import com.uisrael.apipsip.dominio.entidades.Tecnico;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.TecnicoJpa;

@Mapper (componentModel = "spring")
public interface ITecnicoJpaMapper{
	Tecnico toDomain(TecnicoJpa entity);
	TecnicoJpa toEntity(Tecnico tecnico);

}

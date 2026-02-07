package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.apipsip.dominio.entidades.SolicitudServicio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.SolicitudServicioJpa;

@Mapper(componentModel = "spring")
public interface ISolicitudServicioJpaMapper {
	@Mapping(source = "cliente.idcliente", target = "idcliente")
    @Mapping(source = "equipo.idequipo", target = "idequipo")
    SolicitudServicio toDomain(SolicitudServicioJpa entity);
    @Mapping(source = "idcliente", target = "cliente.idcliente")
    @Mapping(source = "idequipo", target = "equipo.idequipo")
    SolicitudServicioJpa toEntity(SolicitudServicio solicitud);
}
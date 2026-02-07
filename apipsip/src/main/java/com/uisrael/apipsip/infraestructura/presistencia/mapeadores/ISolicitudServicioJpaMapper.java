package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.apipsip.dominio.entidades.SolicitudServicio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.SolicitudServicioJpa;

@Mapper(componentModel = "spring")
public interface ISolicitudServicioJpaMapper {
    SolicitudServicio toDomain(SolicitudServicioJpa entity);
    SolicitudServicioJpa toEntity(SolicitudServicio solicitud);
}
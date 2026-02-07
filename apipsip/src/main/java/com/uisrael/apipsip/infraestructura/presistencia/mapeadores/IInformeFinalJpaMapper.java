package com.uisrael.apipsip.infraestructura.presistencia.mapeadores;

import org.mapstruct.Mapper;
import com.uisrael.apipsip.dominio.entidades.InformeFinal;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.InformeFinalJpa;

@Mapper(componentModel = "spring")
public interface IInformeFinalJpaMapper {
   
    InformeFinal toDomain(InformeFinalJpa entity);
    InformeFinalJpa toEntity(InformeFinal cliente);
}
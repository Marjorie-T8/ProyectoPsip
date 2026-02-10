package com.uisrael.apipsip.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import com.uisrael.apipsip.dominio.entidades.Cliente;
import com.uisrael.apipsip.dominio.entidades.Tecnico;
import com.uisrael.apipsip.dominio.entidades.Equipo;
import com.uisrael.apipsip.dominio.entidades.TipoServicio;
import com.uisrael.apipsip.dominio.entidades.OrdenTrabajo;
import com.uisrael.apipsip.presentacion.dto.request.OrdenTrabajoRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.OrdenTrabajoResponseDTO;


@Mapper(componentModel = "spring")
public interface IOrdenTrabajoDtoMapper {
	@Mapping(target = "nombreCliente", expression = "java(dominio.getCliente() != null ? dominio.getCliente().getNombre() : \"--\")")
    @Mapping(target = "nombreTecnico", expression = "java(dominio.getTecnico() != null ? dominio.getTecnico().getNombre() : \"--\")")
    @Mapping(target = "nombreEquipo", expression = "java(dominio.getEquipo() != null ? dominio.getEquipo().getModelo() : \"--\")")
    @Mapping(target = "nombreTipoServicio", expression = "java(dominio.getTipoServicio() != null ? dominio.getTipoServicio().getNombre() : \"--\")")
    @Mapping(source = "cliente.idCliente", target = "idCliente")
    @Mapping(source = "tecnico.idTecnico", target = "idTecnico")
    @Mapping(source = "equipo.idEquipo", target = "idEquipo")
    @Mapping(source = "tipoServicio.idTipo", target = "idTipoServicio")
    OrdenTrabajoResponseDTO toResponseDto(OrdenTrabajo dominio);

    @Mapping(source = "idCliente", target = "cliente")
    @Mapping(source = "idTecnico", target = "tecnico")
    @Mapping(source = "idEquipo", target = "equipo")
    @Mapping(source = "idTipoServicio", target = "tipoServicio")
    OrdenTrabajo toDomain(OrdenTrabajoRequestDTO dto);

    // MÉTODOS DE APOYO CORREGIDOS CON 'Integer'
    default Cliente mapC(Integer id) { 
        return (id == null || id == 0) ? null : new Cliente(id, null, null, null, null, null, null, true); 
    }
    default Tecnico mapT(int id) { 
        return (id == 0) ? null : new Tecnico(id, null, null, null, null, true); 
    }

    default Equipo mapE(int id) { 
        return (id == 0) ? null : new Equipo(id, 0, null, null, null, null, true); 
    }

    default TipoServicio mapS(int id) { 
        return (id == 0) ? null : new TipoServicio(id, null, null, true); 
    }
}
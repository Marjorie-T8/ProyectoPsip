package com.uisrael.comusoapi.modelo.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class OrdenTrabajoResponseDTO {
	private Integer idOrden;
    private String codigo;
    private String estado;
    private int idCliente;
    private String nombreCliente;
    private String cedulaRuc; 
    private int idTecnico;
    private String nombreTecnico;
    private int idEquipo;
    private String nombreEquipo; 
    private String numSerie;
    private int idTipoServicio;
    private String nombreTipoServicio;
    private LocalDate fechaSolicitud; 
    private LocalDate fechaCita; 
    private LocalTime horaCita;
    private String descripcionTrabajo; 
    private String observaciones;
    private Boolean activo;
	    
	    
	}
    
    

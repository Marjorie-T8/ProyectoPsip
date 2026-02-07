package com.uisrael.comusoapi.modelo.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class OrdenTrabajoRequestDTO {


	private int idorden;
    private String codigo;
    private int idsolicitud; 

    private LocalDate fechacreacion;  
    private LocalDate fechaCita;     
    private LocalTime horaCita;
  
    private String estado;    
    private int idcliente;
    private int idtecnico;
    private int idequipo;
    private int idtiposervicio;
    private String numseriereal; 
    private String descripcionTrabajo;
    private String observaciones;
    
}





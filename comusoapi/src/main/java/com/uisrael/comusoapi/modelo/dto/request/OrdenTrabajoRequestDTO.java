package com.uisrael.comusoapi.modelo.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data
public class OrdenTrabajoRequestDTO {
	private int idOrden;
    private String codigo;
    private int idCliente;
    private int idTecnico;
    private int idTipoServicio;
    private int idEquipo;
    private LocalDate fechaSolicitud;
    private LocalDate fechaCita;
    private LocalTime horaCita;    
    private String estado;
    private String descripcionTrabajo;
    private String observaciones;
    private Boolean activo;
}

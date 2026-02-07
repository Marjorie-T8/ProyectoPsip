package com.uisrael.apipsip.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SolicitudServicioRequestDTO {
	private int idsolicitud;

    private String codigoticket;

    @NotNull(message = "El ID del cliente es obligatorio")
    private int idcliente;

    @NotNull(message = "El ID del equipo es obligatorio")
    private int idequipo;

    @NotBlank(message = "Debe elegir una modalidad (LOCAL/DOMICILIO)")
    private String modalidadatencion;

    private String direccionservicio; 

    @NotNull(message = "Debe seleccionar una fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private LocalDate fechacita; 

    @NotNull(message = "Debe seleccionar una hora")
    @DateTimeFormat(pattern = "HH:mm") 
    private LocalTime horacita;

    private String estado = "PENDIENTE"; 
}

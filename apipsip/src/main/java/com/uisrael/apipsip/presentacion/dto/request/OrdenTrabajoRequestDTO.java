package com.uisrael.apipsip.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrdenTrabajoRequestDTO {

    private int idorden; 

    @NotBlank(message = "El código es obligatorio")
    private String codigo;

    @NotNull(message = "Debe vincular esta orden a una solicitud")
    private Integer idsolicitud; 

    @NotNull(message = "Debe seleccionar un cliente")
    private Integer idcliente;

    @NotNull(message = "Debe asignar un técnico")
    private Integer idtecnico;

    @NotNull(message = "Debe seleccionar el tipo de servicio")
    private Integer idtipo; 

    @NotNull(message = "Debe seleccionar el equipo")
    private Integer idequipo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechacreacion; // Fecha en que se genera la orden (hoy)

    @NotNull(message = "La fecha de solicitud es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechasolicitud;

    @NotNull(message = "Debe seleccionar una fecha para la cita")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechacita;

    @NotNull(message = "Debe seleccionar una hora para la cita")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horacita;

    @NotBlank(message = "El estado es obligatorio")
    private String estado; 

    @NotBlank(message = "El número de serie físico es obligatorio")
    private String numseriereal; 

    @NotBlank(message = "La descripción del trabajo es obligatoria")
    private String descripciontrabajo;

    private String observaciones;
}




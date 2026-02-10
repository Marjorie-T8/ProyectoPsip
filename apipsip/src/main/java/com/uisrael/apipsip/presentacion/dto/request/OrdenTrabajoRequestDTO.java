package com.uisrael.apipsip.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrdenTrabajoRequestDTO {
	

	private int idOrden;

    @NotBlank(message = "El código es obligatorio")
    private String codigo;


    @NotNull(message = "Debe seleccionar un cliente")
    private int idCliente;

    @NotNull(message = "Debe asignar un técnico")
    private int idTecnico;

    @NotNull(message = "Debe seleccionar el tipo de servicio")
    private int idTipoServicio;

    @NotNull(message = "Debe seleccionar el equipo")
    private int idEquipo;

    @NotNull(message = "La fecha de solicitud es obligatoria")
    private LocalDate fechaSolicitud;

    @NotNull(message = "La fecha de la cita es obligatoria")
    private LocalDate fechaCita;

    @NotNull(message = "La hora de la cita es obligatoria")
    private LocalTime horaCita;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcionTrabajo;

    private String observaciones;
    private Boolean activo;
}

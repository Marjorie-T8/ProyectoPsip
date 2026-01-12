package com.uisrael.apipsip.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import com.uisrael.apipsip.dominio.entidades.Cliente;
import com.uisrael.apipsip.dominio.entidades.Equipo;
import com.uisrael.apipsip.dominio.entidades.Tecnico;
import com.uisrael.apipsip.dominio.entidades.TipoServicio;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrdenTrabajoRequestDTO {
	@NotBlank
	private  int idOrden;
	@NotBlank
	private  String codigo;
	@NotBlank
	private  Cliente cliente;
	@NotBlank
	private Tecnico tecnico;
	@NotBlank
	private  TipoServicio tipoServicio;
	@NotBlank
	private  Equipo equipo;
	@NotBlank
	private  LocalDate fechaSolicitud;
	@NotBlank
	private  LocalDate fechaAgendada;
	@NotBlank
	private LocalTime horaAgendada;
	@NotBlank
	private  String estado;
	@NotBlank
	private  String descripcionTrabajo;
	@NotBlank
	private  String observaciones;


}

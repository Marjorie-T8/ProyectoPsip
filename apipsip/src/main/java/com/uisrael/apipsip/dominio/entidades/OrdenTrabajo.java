package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class OrdenTrabajo implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idOrden;
	private final String codigo;
	private final Cliente cliente;
	private final Tecnico tecnico;
	private final TipoServicio tipoServicio;
	private final Equipo equipo;
	private final LocalDate fechaSolicitud;
	private final LocalDate fechaAgendada;
	private final LocalTime horaAgendada;
	private final String estado;
	private final String descripcionTrabajo;
	private final String observaciones;

	public OrdenTrabajo(
			int idOrden,
			String codigo,
			Cliente cliente,
			Tecnico tecnico,
			TipoServicio tipoServicio,
			Equipo equipo,
			LocalDate fechaSolicitud,
			LocalDate fechaAgendada,
			LocalTime horaAgendada,
			String estado,
			String descripcionTrabajo,
			String observaciones) {

		this.idOrden = idOrden;
		this.codigo = codigo;
		this.cliente = cliente;
		this.tecnico = tecnico;
		this.tipoServicio = tipoServicio;
		this.equipo = equipo;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaAgendada = fechaAgendada;
		this.horaAgendada = horaAgendada;
		this.estado = estado;
		this.descripcionTrabajo = descripcionTrabajo;
		this.observaciones = observaciones;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public String getCodigo() {
		return codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public Equipo getEquipo() {
		return equipo;
	}
	public String getEstado() {
		return estado;
	}

	public String getDescripcionTrabajo() {
		return descripcionTrabajo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public LocalDate getFechaAgendada() {
		return fechaAgendada;
	}

	public LocalTime getHoraAgendada() {
		return horaAgendada;
	}

}
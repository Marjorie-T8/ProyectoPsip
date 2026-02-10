package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class OrdenTrabajo implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idOrden;
	private final String codigo;
	private final int idCliente;
    private final int idTecnico;
    private final int idTipoServicio;
    private final int idEquipo;
	private final LocalDate fechaSolicitud;
	private final LocalDate fechaCita; 
    private final LocalTime horaCita;
	private final String estado;
	private final String descripcionTrabajo;
	private final String observaciones;
	private final Boolean activo;
	public OrdenTrabajo(int idOrden, String codigo, int idCliente, int idTecnico, int idTipoServicio, int idEquipo,
			LocalDate fechaSolicitud, LocalDate fechaCita, LocalTime horaCita, String estado, String descripcionTrabajo,
			String observaciones, Boolean activo) {
		super();
		this.idOrden = idOrden;
		this.codigo = codigo;
		this.idCliente = idCliente;
		this.idTecnico = idTecnico;
		this.idTipoServicio = idTipoServicio;
		this.idEquipo = idEquipo;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaCita = fechaCita;
		this.horaCita = horaCita;
		this.estado = estado;
		this.descripcionTrabajo = descripcionTrabajo;
		this.observaciones = observaciones;
		this.activo = activo;

	
	
}
	public int getIdOrden() {
		return idOrden;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public int getIdTecnico() {
		return idTecnico;
	}
	public int getIdTipoServicio() {
		return idTipoServicio;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}
	public LocalDate getFechaCita() {
		return fechaCita;
	}
	public LocalTime getHoraCita() {
		return horaCita;
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
	public Boolean getActivo() {
		return activo;
	}
}
	
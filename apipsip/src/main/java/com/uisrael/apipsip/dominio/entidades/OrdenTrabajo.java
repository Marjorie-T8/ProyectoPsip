package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class OrdenTrabajo implements Serializable {

	private static final long serialVersionUID = 1L;
	private final Integer idOrden;
    private final String codigo;
    private final Cliente cliente;        
    private final Tecnico tecnico;        
    private final TipoServicio tipoServicio; 
    private final Equipo equipo;
    private final LocalDate fechaSolicitud; 
    private final LocalDate fechaCita; 
    private final LocalTime horaCita;    
    private final String estado;
    private final String descripcionTrabajo; 
    private final String observaciones;
    private final Boolean activo;
	public OrdenTrabajo(Integer idOrden, String codigo, Cliente cliente, Tecnico tecnico, TipoServicio tipoServicio,
			Equipo equipo, LocalDate fechaSolicitud, LocalDate fechaCita, LocalTime horaCita, String estado,
			String descripcionTrabajo, String observaciones, Boolean activo) {
		super();
		this.idOrden = idOrden;
		this.codigo = codigo;
		this.cliente = cliente;
		this.tecnico = tecnico;
		this.tipoServicio = tipoServicio;
		this.equipo = equipo;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaCita = fechaCita;
		this.horaCita = horaCita;
		this.estado = estado;
		this.descripcionTrabajo = descripcionTrabajo;
		this.observaciones = observaciones;
		this.activo = activo;
	}
	public Integer getIdOrden() {
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
	
package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HistorialEstado implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idhistorial;
	private final int idorden;
	private final String estadoAnterior;
	private final String estadoNuevo;
	private final LocalDateTime fechaCambio;
	private final String observacion;
	private final String modificadoPor;
	
	public HistorialEstado(int idHistorial, int idOrden, String estadoAnterior, String estadoNuevo, 
			LocalDateTime fechaCambio, String observacion, String modificadoPor) {
		this.idhistorial = idHistorial;
		this.idorden = idOrden;
		this.estadoAnterior = estadoAnterior;
		this.estadoNuevo = estadoNuevo;
		this.fechaCambio = fechaCambio;
		this.observacion = observacion;
		this.modificadoPor = modificadoPor;
	}
	
	public int getIdHistorial() {
		return idhistorial;
	}
	
	public int getIdOrden() {
		return idorden;
	}
	
	public String getEstadoAnterior() {
		return estadoAnterior;
	}
	
	public String getEstadoNuevo() {
		return estadoNuevo;
	}
	
	public LocalDateTime getFechaCambio() {
		return fechaCambio;
	}
	
	public String getObservacion() {
		return observacion;
	}
	
	public String getModificadoPor() {
		return modificadoPor;
	}
}
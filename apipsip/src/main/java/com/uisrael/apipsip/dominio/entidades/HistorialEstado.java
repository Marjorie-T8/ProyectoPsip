package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HistorialEstado implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idhistorial;
	private final int idorden;
	private final String estadoanterior;
	private final String estadonuevo;
	private final LocalDateTime fechacambio;
	private final String observacion;
	private final String modificadoPor;
	
	public HistorialEstado(int idhistorial, int idorden, String estadoanterior, String estadonuevo, 
			LocalDateTime fechacambio, String observacion, String modificadoPor) {
		this.idhistorial = idhistorial;
		this.idorden = idorden;
		this.estadoanterior = estadoanterior;
		this.estadonuevo = estadonuevo;
		this.fechacambio = fechacambio;
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
		return estadoanterior;
	}
	
	public String getEstadoNuevo() {
		return estadonuevo;
	}
	
	public LocalDateTime getFechaCambio() {
		return fechacambio;
	}
	
	public String getObservacion() {
		return observacion;
	}
	
	public String getModificadoPor() {
		return modificadoPor;
	}
}
package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FotoVerificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idfoto;
	private final int idorden;
	private final String rutaArchivo;
	private final String descripcion;
	private final LocalDateTime fechaRegistro;
	
	public FotoVerificacion(int idFoto, int idOrden, String rutaArchivo, String descripcion, LocalDateTime fechaRegistro) {
		this.idfoto = idFoto;
		this.idorden = idOrden;
		this.rutaArchivo = rutaArchivo;
		this.descripcion = descripcion;
		this.fechaRegistro = fechaRegistro;
	}
	
	public int getIdFoto() {
		return idfoto;
	}
	
	public int getIdOrden() {
		return idorden;
	}
	
	public String getRutaArchivo() {
		return rutaArchivo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
}
package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FotoVerificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idfoto;
	private final int idorden;
	private final String rutaarchivo;
	private final String descripcion;
	private final LocalDateTime fechaRegistro;
	
	public FotoVerificacion(int idfoto, int idorden, String rutaarchivo, String descripcion, LocalDateTime fechaRegistro) {
		this.idfoto = idfoto;
		this.idorden = idorden;
		this.rutaarchivo = rutaarchivo;
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
		return rutaarchivo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
}
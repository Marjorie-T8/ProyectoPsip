package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FotoVerificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idFoto;
	private final int idOrden;
	private final String rutaArchivo;
	private final String descripcion;
	private final LocalDateTime fechaRegistro;
	
	public FotoVerificacion(int idFoto, int idOrden, String rutaArchivo, String descripcion, LocalDateTime fechaRegistro) {
		this.idFoto = idFoto;
		this.idOrden = idOrden;
		this.rutaArchivo = rutaArchivo;
		this.descripcion = descripcion;
		this.fechaRegistro = fechaRegistro;
	}
	
	public int getIdFoto() {
		return idFoto;
	}
	
	public int getIdOrden() {
		return idOrden;
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
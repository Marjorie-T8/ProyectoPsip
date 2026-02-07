package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AnexoDocumentos implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idAnexo;
	private final int idOrden;
	private final String nombreOriginal;
	private final String nombreGuardado;
	private final String tipoMime;
	private final LocalDateTime fechaSubida;
	private final boolean estado;
	
	public AnexoDocumentos(int idAnexo, int idOrden, String nombreOriginal, String nombreGuardado, 
			String tipoMime, LocalDateTime fechaSubida, boolean estado) {
		this.idAnexo = idAnexo;
		this.idOrden = idOrden;
		this.nombreOriginal = nombreOriginal;
		this.nombreGuardado = nombreGuardado;
		this.tipoMime = tipoMime;
		this.fechaSubida = fechaSubida;
		this.estado = estado;
	}
	
	public int getIdAnexo() {
		return idAnexo;
	}
	
	public int getIdOrden() {
		return idOrden;
	}
	
	public String getNombreOriginal() {
		return nombreOriginal;
	}
	
	public String getNombreGuardado() {
		return nombreGuardado;
	}
	
	public String getTipoMime() {
		return tipoMime;
	}
	
	public LocalDateTime getFechaSubida() {
		return fechaSubida;
	}
	
	public boolean isEstado() {
		return estado;
	}
}

package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AnexoDocumentos implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idanexo;
	private final int idorden;
	private final String nombreoriginal;
	private final String nombreguardado;
	private final String tipomime;
	private final LocalDateTime fechaSubida;
	private final boolean estado;
	
	public AnexoDocumentos(int idanexo, int idorden, String nombreoriginal, String nombreguardado, 
			String tipomime, LocalDateTime fechaSubida, boolean estado) {
		this.idanexo = idanexo;
		this.idorden = idorden;
		this.nombreoriginal = nombreoriginal;
		this.nombreguardado = nombreguardado;
		this.tipomime = tipomime;
		this.fechaSubida = fechaSubida;
		this.estado = estado;
	}
	
	public int getIdAnexo() {
		return idanexo;
	}
	
	public int getIdOrden() {
		return idorden;
	}
	
	public String getNombreOriginal() {
		return nombreoriginal;
	}
	
	public String getNombreGuardado() {
		return nombreguardado;
	}
	
	public String getTipoMime() {
		return tipomime;
	}
	
	public LocalDateTime getFechaSubida() {
		return fechaSubida;
	}
	
	public boolean isEstado() {
		return estado;
	}
}

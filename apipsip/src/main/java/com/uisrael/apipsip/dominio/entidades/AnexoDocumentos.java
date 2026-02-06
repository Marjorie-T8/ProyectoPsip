package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;


public class AnexoDocumentos implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private final int idAnexo;
	private final OrdenTrabajo ordenTrabajo;
	private final String nombreOriginal;
	private final String nombreGuardado;
	private final String tipoMime;
	private final LocalDateTime fechaSubida;
	private final boolean estado;
	
	public AnexoDocumentos(int idAnexo, OrdenTrabajo ordenTrabajo, String nombreOriginal, String nombreGuardado,
			String tipoMime, LocalDateTime fechaSubida, boolean estado) {
		super();
		this.idAnexo = idAnexo;
		this.ordenTrabajo = ordenTrabajo;
		this.nombreOriginal = nombreOriginal;
		this.nombreGuardado = nombreGuardado;
		this.tipoMime = tipoMime;
		this.fechaSubida = fechaSubida;
		this.estado = estado;
	}

	public int getIdAnexo() {
		return idAnexo;
	}

	public OrdenTrabajo getOrdenTrabajo() {
		return ordenTrabajo;
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

	@Override
	public String toString() {
		return "AnexoDocumentos [idAnexo=" + idAnexo + ", ordenTrabajo=" + ordenTrabajo + ", nombreOriginal="
				+ nombreOriginal + ", nombreGuardado=" + nombreGuardado + ", tipoMime=" + tipoMime + ", fechaSubida="
				+ fechaSubida + ", estado=" + estado + "]";
	}
	
	
	
}

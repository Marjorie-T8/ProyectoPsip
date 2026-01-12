package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class TipoServicio implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idTipo;
	private final String nombre;
	private final String descripcion;

	public TipoServicio(int idTipo, String nombre, String descripcion) {
		this.idTipo = idTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
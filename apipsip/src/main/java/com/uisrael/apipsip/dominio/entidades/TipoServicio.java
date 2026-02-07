package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class TipoServicio implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idtipo;
	private final String nombre;
	private final String descripcion;
	public TipoServicio(int idtipo, String nombre, String descripcion) {
		super();
		this.idtipo = idtipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public int getIdtipo() {
		return idtipo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}

	
}
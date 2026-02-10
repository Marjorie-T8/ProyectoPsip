package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class TipoServicio implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idTipo;
	private final String nombre;
	private final String descripcion;
	private final  Boolean activo;
	public TipoServicio(int idTipo, String nombre, String descripcion, Boolean activo) {
		super();
		this.idTipo = idTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
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
	public Boolean getActivo() {
		return activo;
	}
	
	
	
	
}
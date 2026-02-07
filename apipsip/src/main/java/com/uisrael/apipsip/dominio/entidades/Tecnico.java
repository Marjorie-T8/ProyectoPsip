package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class Tecnico implements Serializable {

	private static final long serialVersionUID = 1L;
	private final int idtecnico;
	private final String nombre;
	private final String email;
	private final String telefono;
	private final boolean activo;
	public Tecnico(int idtecnico, String nombre, String email, String telefono, boolean activo) {
		super();
		this.idtecnico = idtecnico;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.activo = activo;
	}
	public int getIdtecnico() {
		return idtecnico;
	}
	public String getNombre() {
		return nombre;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefono() {
		return telefono;
	}
	public boolean isActivo() {
		return activo;
	}

	
}
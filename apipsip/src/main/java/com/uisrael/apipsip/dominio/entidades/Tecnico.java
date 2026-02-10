package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class Tecnico implements Serializable {

	private static final long serialVersionUID = 1L;
	private final int idTecnico;
	private final String nombre;
	private final String cedula;
	private final String email;
	private final String telefono;
	private final Boolean activo;
	public Tecnico(int idTecnico, String nombre, String cedula, String email, String telefono, Boolean activo) {
		super();
		this.idTecnico = idTecnico;
		this.nombre = nombre;
		this.cedula = cedula;
		this.email = email;
		this.telefono = telefono;
		this.activo = activo;
	}
	public int getIdTecnico() {
		return idTecnico;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefono() {
		return telefono;
	}
	public Boolean getActivo() {
		return activo;
	}
	
	
}
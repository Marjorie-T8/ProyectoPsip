package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class Cliente implements Serializable {


	private static final long serialVersionUID = 1L;
	private final  int idcliente;
	private final String nombre;
	private final String email; 
	private final String telefono;
	private final String direccion;
	private final Boolean estado;
	public Cliente(int idcliente, String nombre, String email, String telefono, String direccion, Boolean estado) {
		super();
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.estado = estado;
	}
	public int getIdcliente() {
		return idcliente;
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
	public String getDireccion() {
		return direccion;
	}
	public Boolean getEstado() {
		return estado;
	}
	
	

}

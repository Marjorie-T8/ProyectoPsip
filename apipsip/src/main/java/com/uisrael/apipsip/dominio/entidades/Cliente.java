package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente implements Serializable {


	private static final long serialVersionUID = 1L;
	private final  int idCliente;
	private final String cedula;         
    private final String nombre;
    private final String email;
    private final String telefono;
    private final String direccion;
    private final LocalDate fechaNacimiento; 
    private final Boolean estado;
	public Cliente(int idCliente, String cedula, String nombre, String email, String telefono, String direccion,
			LocalDate fechaNacimiento, Boolean estado) {
		super();
		this.idCliente = idCliente;
		this.cedula = cedula;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public String getCedula() {
		return cedula;
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
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public Boolean getEstado() {
		return estado;
	}
	
	
	

}

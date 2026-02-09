package com.uisrael.apipsip.presentacion.dto.response;

import java.time.LocalDate;

public class ClienteResponseDTO {

	private int idCliente;
	private String cedula;  
	private String nombre;
	private String email; 
	private  String telefono;
	private String direccion;
	private  LocalDate fechaNacimiento; 
	private Boolean estado;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public String getCedula() {
		return cedula;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	


}

package com.uisrael.apipsip.presentacion.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;
public class OrdenTrabajoResponseDTO {

	private int idorden;
    private String codigo;
    private int idsolicitud; 

    private LocalDate fechacreacion; 
    private LocalDate fechacita;     
    private LocalTime horacita;
    
    
    private String estado; 
    
    private int idcliente;
    private int idtecnico;
    private int idequipo;
    private int idtiposervicio;


    private String numseriereal; 
    private String descripcionTrabajo;
    private String observaciones;
	public int getIdorden() {
		return idorden;
	}
	public void setIdorden(int idorden) {
		this.idorden = idorden;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public LocalDate getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(LocalDate fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	public LocalDate getFechaCita() {
		return fechacita;
	}
	public void setFechaCita(LocalDate fechaCita) {
		this.fechacita = fechaCita;
	}
	public LocalTime getHoraCita() {
		return horacita;
	}
	public void setHoraCita(LocalTime horaCita) {
		this.horacita = horaCita;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdtecnico() {
		return idtecnico;
	}
	public void setIdtecnico(int idtecnico) {
		this.idtecnico = idtecnico;
	}
	public int getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}
	public int getIdtiposervicio() {
		return idtiposervicio;
	}
	public void setIdtiposervicio(int idtiposervicio) {
		this.idtiposervicio = idtiposervicio;
	}
	public String getNumseriereal() {
		return numseriereal;
	}
	public void setNumseriereal(String numseriereal) {
		this.numseriereal = numseriereal;
	}
	public String getDescripcionTrabajo() {
		return descripcionTrabajo;
	}
	public void setDescripcionTrabajo(String descripcionTrabajo) {
		this.descripcionTrabajo = descripcionTrabajo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
    
}
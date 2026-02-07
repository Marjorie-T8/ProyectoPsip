package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class OrdenTrabajo implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idorden;
    private final String codigo;
    private final  int idsolicitud; // El vínculo con el ticket original

    // FECHAS DIFERENCIADAS
    private final  LocalDate fechacreacion;  // Hoy: El día que el técnico genera la orden
    private final  LocalDate fechaCita;      // El día que el cliente debe venir (ej: 3 días después)
    private final  LocalTime horaCita;
    
    // ESTADOS SEGÚN TU LÓGICA
    private final  String estado; // Inicia en 'CONFIRMADO' y se queda así hasta el día de la cita
    
    private final  int idcliente;
    private final  int idtecnico;
    private final  int idequipo;
    private final int idtiposervicio;

    // Estos se llenan RECIÉN el día de la cita
    private final String numseriereal; 
    private final String descripcionTrabajo;
    private final  String observaciones;
	public OrdenTrabajo(int idorden, String codigo, int idsolicitud, LocalDate fechacreacion, LocalDate fechaCita,
			LocalTime horaCita, String estado, int idcliente, int idtecnico, int idequipo, int idtiposervicio,
			String numseriereal, String descripcionTrabajo, String observaciones) {
		super();
		this.idorden = idorden;
		this.codigo = codigo;
		this.idsolicitud = idsolicitud;
		this.fechacreacion = fechacreacion;
		this.fechaCita = fechaCita;
		this.horaCita = horaCita;
		this.estado = estado;
		this.idcliente = idcliente;
		this.idtecnico = idtecnico;
		this.idequipo = idequipo;
		this.idtiposervicio = idtiposervicio;
		this.numseriereal = numseriereal;
		this.descripcionTrabajo = descripcionTrabajo;
		this.observaciones = observaciones;
	}
	public int getIdorden() {
		return idorden;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getIdsolicitud() {
		return idsolicitud;
	}
	public LocalDate getFechacreacion() {
		return fechacreacion;
	}
	public LocalDate getFechaCita() {
		return fechaCita;
	}
	public LocalTime getHoraCita() {
		return horaCita;
	}
	public String getEstado() {
		return estado;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public int getIdtecnico() {
		return idtecnico;
	}
	public int getIdequipo() {
		return idequipo;
	}
	public int getIdtiposervicio() {
		return idtiposervicio;
	}
	public String getNumseriereal() {
		return numseriereal;
	}
	public String getDescripcionTrabajo() {
		return descripcionTrabajo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	
	
    
}
	    
	
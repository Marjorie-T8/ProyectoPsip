package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class SolicitudServicio implements Serializable {
    

	private static final long serialVersionUID = 1L;
	private final int idsolicitud;
    private final String codigoticket; 
    private final int idcliente;
    private final int idequipo;
    private final String modalidadatencion; 
    private final String direccionservicio;
    private final LocalDate fechacita;
    private final LocalTime horacita;
    private final String estado;
	public SolicitudServicio(int idsolicitud, String codigoticket, int idcliente, int idequipo,
			String modalidadatencion, String direccionservicio, LocalDate fechacita, LocalTime horacita,
			String estado) {
		super();
		this.idsolicitud = idsolicitud;
		this.codigoticket = codigoticket;
		this.idcliente = idcliente;
		this.idequipo = idequipo;
		this.modalidadatencion = modalidadatencion;
		this.direccionservicio = direccionservicio;
		this.fechacita = fechacita;
		this.horacita = horacita;
		this.estado = estado;
	}
	public int getIdsolicitud() {
		return idsolicitud;
	}
	public String getCodigoticket() {
		return codigoticket;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public int getIdequipo() {
		return idequipo;
	}
	public String getModalidadatencion() {
		return modalidadatencion;
	}
	public String getDireccionservicio() {
		return direccionservicio;
	}
	public LocalDate getFechacita() {
		return fechacita;
	}
	public LocalTime getHoracita() {
		return horacita;
	}
	public String getEstado() {
		return estado;
	}
	
    
}

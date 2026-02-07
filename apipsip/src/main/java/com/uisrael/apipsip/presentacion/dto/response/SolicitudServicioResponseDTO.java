package com.uisrael.apipsip.presentacion.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class SolicitudServicioResponseDTO {
	private int idsolicitud;
    private String codigoticket; 
    private int idcliente;
    private int idequipo;
    private String modalidadatencion; 
    private String direccionservicio;
    private LocalDate fechacita;
    private LocalTime horacita;
    private String estado;
	public int getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public String getCodigoticket() {
		return codigoticket;
	}
	public void setCodigoticket(String codigoticket) {
		this.codigoticket = codigoticket;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}
	public String getModalidadatencion() {
		return modalidadatencion;
	}
	public void setModalidadatencion(String modalidadatencion) {
		this.modalidadatencion = modalidadatencion;
	}
	public String getDireccionservicio() {
		return direccionservicio;
	}
	public void setDireccionservicio(String direccionservicio) {
		this.direccionservicio = direccionservicio;
	}
	public LocalDate getFechacita() {
		return fechacita;
	}
	public void setFechacita(LocalDate fechacita) {
		this.fechacita = fechacita;
	}
	public LocalTime getHoracita() {
		return horacita;
	}
	public void setHoracita(LocalTime horacita) {
		this.horacita = horacita;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}

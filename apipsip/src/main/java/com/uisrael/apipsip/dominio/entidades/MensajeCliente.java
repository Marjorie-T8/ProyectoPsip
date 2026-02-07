package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MensajeCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idMensaje;
	private final int idOrden;
	private final String tipoMensaje;
	private final String medio;
	private final String destinatario;
	private final String contenido;
	private final LocalDateTime fechaEnvio;
	private final String estadoEnvio;
	
	public MensajeCliente(int idMensaje, int idOrden, String tipoMensaje, String medio, String destinatario, 
			String contenido, LocalDateTime fechaEnvio, String estadoEnvio) {
		this.idMensaje = idMensaje;
		this.idOrden = idOrden;
		this.tipoMensaje = tipoMensaje;
		this.medio = medio;
		this.destinatario = destinatario;
		this.contenido = contenido;
		this.fechaEnvio = fechaEnvio;
		this.estadoEnvio = estadoEnvio;
	}
	
	public int getIdMensaje() {
		return idMensaje;
	}
	
	public int getIdOrden() {
		return idOrden;
	}
	
	public String getTipoMensaje() {
		return tipoMensaje;
	}
	
	public String getMedio() {
		return medio;
	}
	
	public String getDestinatario() {
		return destinatario;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}
	
	public String getEstadoEnvio() {
		return estadoEnvio;
	}
}
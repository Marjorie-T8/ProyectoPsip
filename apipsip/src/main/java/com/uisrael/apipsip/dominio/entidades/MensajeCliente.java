package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MensajeCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idmensaje;
	private final int idorden;
	private final String tipoMensaje;
	private final String medio;
	private final String destinatario;
	private final String contenido;
	private final LocalDateTime fechaEnvio;
	private final String estadoEnvio;
	
	public MensajeCliente(int idMensaje, int idOrden, String tipoMensaje, String medio, String destinatario, 
			String contenido, LocalDateTime fechaEnvio, String estadoEnvio) {
		this.idmensaje = idMensaje;
		this.idorden = idOrden;
		this.tipoMensaje = tipoMensaje;
		this.medio = medio;
		this.destinatario = destinatario;
		this.contenido = contenido;
		this.fechaEnvio = fechaEnvio;
		this.estadoEnvio = estadoEnvio;
	}
	
	public int getIdMensaje() {
		return idmensaje;
	}
	
	public int getIdOrden() {
		return idorden;
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
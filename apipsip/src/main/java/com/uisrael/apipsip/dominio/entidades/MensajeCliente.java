package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MensajeCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idmensaje;
	private final int idorden;
	private final String tipomensaje;
	private final String medio;
	private final String destinatario;
	private final String contenido;
	private final LocalDateTime fechaenvio;
	private final String estadoenvio;
	
	public MensajeCliente(int idmensaje, int idorden, String tipomensaje, String medio, String destinatario, 
			String contenido, LocalDateTime fechaenvio, String estadoEnvio) {
		this.idmensaje = idmensaje;
		this.idorden = idorden;
		this.tipomensaje = tipomensaje;
		this.medio = medio;
		this.destinatario = destinatario;
		this.contenido = contenido;
		this.fechaenvio = fechaenvio;
		this.estadoenvio = estadoEnvio;
	}
	
	public int getIdMensaje() {
		return idmensaje;
	}
	
	public int getIdOrden() {
		return idorden;
	}
	
	public String getTipoMensaje() {
		return tipomensaje;
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
		return fechaenvio;
	}
	
	public String getEstadoEnvio() {
		return estadoenvio;
	}
}
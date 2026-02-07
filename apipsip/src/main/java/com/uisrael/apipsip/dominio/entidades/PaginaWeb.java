package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PaginaWeb implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idAcceso;
	private final int idOrden;
	private final int ipCliente;
	private final String userAgent;
	private final LocalDateTime fechaAcceso;
	private final String tipoAcceso;
	
	public PaginaWeb(int idAcceso, int idOrden, int ipCliente, String userAgent, 
			LocalDateTime fechaAcceso, String tipoAcceso) {
		this.idAcceso = idAcceso;
		this.idOrden = idOrden;
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
		this.fechaAcceso = fechaAcceso;
		this.tipoAcceso = tipoAcceso;
	}
	
	public int getIdAcceso() {
		return idAcceso;
	}
	
	public int getIdOrden() {
		return idOrden;
	}
	
	public int getIpCliente() {
		return ipCliente;
	}
	
	public String getUserAgent() {
		return userAgent;
	}
	
	public LocalDateTime getFechaAcceso() {
		return fechaAcceso;
	}
	
	public String getTipoAcceso() {
		return tipoAcceso;
	}
}
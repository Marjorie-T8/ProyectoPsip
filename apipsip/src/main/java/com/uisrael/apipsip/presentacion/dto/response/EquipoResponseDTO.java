package com.uisrael.apipsip.presentacion.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquipoResponseDTO {
	@JsonProperty("idequipo")
	private int idequipo;
	@JsonProperty("idcliente")
	private  int idcliente;
	private String tipo;
	private  String marca;

	private  String modelo;
	private String numserie;
	private String estadoequipo;
	public int getIdequipo() {
		return idequipo;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public String getTipo() {
		return tipo;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getNumserie() {
		return numserie;
	}
	public String getEstadoequipo() {
		return estadoequipo;
	}

}
	

	


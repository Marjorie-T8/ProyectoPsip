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
	public EquipoResponseDTO() {
    }
	public int getIdequipo() {
		return idequipo;
	}
	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNumserie() {
		return numserie;
	}
	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}
	public String getEstadoequipo() {
		return estadoequipo;
	}
	public void setEstadoequipo(String estadoequipo) {
		this.estadoequipo = estadoequipo;
	}
	
}
	

	


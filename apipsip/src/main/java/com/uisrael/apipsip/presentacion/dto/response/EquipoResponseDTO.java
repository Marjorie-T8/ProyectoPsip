package com.uisrael.apipsip.presentacion.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquipoResponseDTO {
	
	private  int idEquipo;
	@JsonProperty("idcliente")
	  private int idCliente; 
	
	private  String marca;
	
	private  String modelo;
	@JsonProperty("numserie")
	private  String numserie;
	
	private String descripcion;

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	
}

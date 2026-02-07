package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class Equipo implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idequipo;
	private final int idcliente;
	private final String tipo;
	private final String marca;
	private final String modelo;
	private final String numserie;
	private final String estadoequipo;
	public Equipo(int idequipo, int idcliente, String tipo, String marca, String modelo, String numserie,
			String estadoequipo) {
		super();
		this.idequipo = idequipo;
		this.idcliente = idcliente;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.numserie = numserie;
		this.estadoequipo = estadoequipo;
	}
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



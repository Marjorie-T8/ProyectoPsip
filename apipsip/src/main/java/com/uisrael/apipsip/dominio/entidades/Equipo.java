package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class Equipo implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idEquipo;
	private final String marca;
	private final String modelo;
	private final String numSerie;
	private final String descripcion;

public Equipo(int idEquipo, String marca, String modelo, String numSerie, String descripcion) {
		this.idEquipo = idEquipo;
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.descripcion = descripcion;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
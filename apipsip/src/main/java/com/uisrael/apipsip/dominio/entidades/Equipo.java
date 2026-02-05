package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class Equipo implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idEquipo;
	private final int idCliente;
	private final String marca;
	private final String modelo;
	private final String numSerie;
	private final String descripcion;


public Equipo(int idEquipo, int idCliente, String marca, String modelo, String numSerie, String descripcion) {
		super();
		this.idEquipo = idEquipo;
		this.idCliente = idCliente;
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.descripcion = descripcion;
	}


public int getIdEquipo() {
	return idEquipo;
}


public int getIdCliente() {
	return idCliente;
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


@Override
public String toString() {
	return "Equipo [idEquipo=" + idEquipo + ", idCliente=" + idCliente + ", marca=" + marca + ", modelo=" + modelo
			+ ", numSerie=" + numSerie + ", descripcion=" + descripcion + "]";
}



	
}
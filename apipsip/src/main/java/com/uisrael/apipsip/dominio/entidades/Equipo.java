package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class Equipo implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Integer idEquipo;
	private final Integer idCliente;
	private final String marca;
	private final String modelo;
	private final String numserie;
	private final String descripcion;
	private final Boolean activo;
	public Equipo(Integer idEquipo, Integer idCliente, String marca, String modelo, String numserie, String descripcion,
			Boolean activo) {
		super();
		this.idEquipo = idEquipo;
		this.idCliente = idCliente;
		this.marca = marca;
		this.modelo = modelo;
		this.numserie = numserie;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	public Integer getIdEquipo() {
		return idEquipo;
	}
	public Integer getIdCliente() {
		return idCliente;
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
	public String getDescripcion() {
		return descripcion;
	}
	public Boolean getActivo() {
		return activo;
	}
	
	
	
}
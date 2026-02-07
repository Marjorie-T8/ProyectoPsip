package com.uisrael.apipsip.dominio.entidades;

import java.io.Serializable;

public class InformeFinal implements Serializable {
   
	private static final long serialVersionUID = 1L;
	private final int idinforme;
    private final int idorden;
    private final String detallefinal;
    private final double costorepuestos;
    private final double costomanodeobra;
    private final double total;
	public InformeFinal(int idinforme, int idorden, String detallefinal, double costorepuestos, double costomanodeobra,
			double total) {
		super();
		this.idinforme = idinforme;
		this.idorden = idorden;
		this.detallefinal = detallefinal;
		this.costorepuestos = costorepuestos;
		this.costomanodeobra = costomanodeobra;
		this.total = total;
	}
	public int getIdinforme() {
		return idinforme;
	}
	public int getIdorden() {
		return idorden;
	}
	public String getDetallefinal() {
		return detallefinal;
	}
	public double getCostorepuestos() {
		return costorepuestos;
	}
	public double getCostomanodeobra() {
		return costomanodeobra;
	}
	public double getTotal() {
		return total;
	}
	
    
}
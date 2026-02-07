package com.uisrael.apipsip.presentacion.dto.response;

public class InformeFinalResponseDTO {
	private int idinforme;
    private int idorden;
    private String detallefinal;
    private double costorepuestos;
    private double costomanodeobra;
    private double total;
	public int getIdinforme() {
		return idinforme;
	}
	public void setIdinforme(int idinforme) {
		this.idinforme = idinforme;
	}
	public int getIdorden() {
		return idorden;
	}
	public void setIdorden(int idorden) {
		this.idorden = idorden;
	}
	public String getDetallefinal() {
		return detallefinal;
	}
	public void setDetallefinal(String detallefinal) {
		this.detallefinal = detallefinal;
	}
	public double getCostorepuestos() {
		return costorepuestos;
	}
	public void setCostorepuestos(double costorepuestos) {
		this.costorepuestos = costorepuestos;
	}
	public double getCostomanodeobra() {
		return costomanodeobra;
	}
	public void setCostomanodeobra(double costomanodeobra) {
		this.costomanodeobra = costomanodeobra;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}

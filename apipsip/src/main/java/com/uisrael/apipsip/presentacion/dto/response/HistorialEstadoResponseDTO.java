package com.uisrael.apipsip.presentacion.dto.response;

import java.time.LocalDateTime;

public class HistorialEstadoResponseDTO {

    private int idhistorial;
    private int idorden;
    private String estadoanterior;
    private String estadonuevo;
    private LocalDateTime fechacambio;
    private String observacion;
    private String modificadopor;

    public int getIdhistorial() {
        return idhistorial;
    }

    public void setIdhistorial(int idhistorial) {
        this.idhistorial = idhistorial;
    }

    public int getIdorden() {
        return idorden;
    }

    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    public String getEstadoanterior() {
        return estadoanterior;
    }

    public void setEstadoanterior(String estadoanterior) {
        this.estadoanterior = estadoanterior;
    }

    public String getEstadonuevo() {
        return estadonuevo;
    }

    public void setEstadonuevo(String estadonuevo) {
        this.estadonuevo = estadonuevo;
    }

    public LocalDateTime getFechacambio() {
        return fechacambio;
    }

    public void setFechacambio(LocalDateTime fechacambio) {
        this.fechacambio = fechacambio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getModificadopor() {
        return modificadopor;
    }

    public void setModificadopor(String modificadopor) {
        this.modificadopor = modificadopor;
    }
}
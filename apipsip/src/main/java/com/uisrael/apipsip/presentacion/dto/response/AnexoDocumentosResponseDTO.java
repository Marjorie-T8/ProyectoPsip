package com.uisrael.apipsip.presentacion.dto.response;

import java.time.LocalDateTime;

public class AnexoDocumentosResponseDTO {

    private int idanexo;
    private int idorden;
    private String nombreoriginal;
    private String nombreguardado;
    private String tipomime;
    private LocalDateTime fechasubida;
    private boolean estado;

    public int getIdanexo() {
        return idanexo;
    }

    public void setIdanexo(int idanexo) {
        this.idanexo = idanexo;
    }

    public int getIdorden() {
        return idorden;
    }

    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    public String getNombreoriginal() {
        return nombreoriginal;
    }

    public void setNombreoriginal(String nombreoriginal) {
        this.nombreoriginal = nombreoriginal;
    }

    public String getNombreguardado() {
        return nombreguardado;
    }

    public void setNombreguardado(String nombreguardado) {
        this.nombreguardado = nombreguardado;
    }

    public String getTipomime() {
        return tipomime;
    }

    public void setTipomime(String tipomime) {
        this.tipomime = tipomime;
    }

    public LocalDateTime getFechasubida() {
        return fechasubida;
    }

    public void setFechasubida(LocalDateTime fechasubida) {
        this.fechasubida = fechasubida;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
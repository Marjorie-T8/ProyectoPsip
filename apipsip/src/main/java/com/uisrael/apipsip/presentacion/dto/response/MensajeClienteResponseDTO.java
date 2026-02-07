package com.uisrael.apipsip.presentacion.dto.response;

import java.time.LocalDateTime;

public class MensajeClienteResponseDTO {

    private int idmensaje;
    private int idorden;
    private String tipomensaje;
    private String medio;
    private String destinatario;
    private String contenido;
    private LocalDateTime fechaenvio;
    private String estadoenvio;

    public int getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(int idmensaje) {
        this.idmensaje = idmensaje;
    }

    public int getIdorden() {
        return idorden;
    }

    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    public String getTipomensaje() {
        return tipomensaje;
    }

    public void setTipomensaje(String tipomensaje) {
        this.tipomensaje = tipomensaje;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaenvio() {
        return fechaenvio;
    }

    public void setFechaenvio(LocalDateTime fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    public String getEstadoenvio() {
        return estadoenvio;
    }

    public void setEstadoenvio(String estadoenvio) {
        this.estadoenvio = estadoenvio;
    }
}
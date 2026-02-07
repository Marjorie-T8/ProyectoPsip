package com.uisrael.apipsip.presentacion.dto.response;

import java.time.LocalDateTime;

public class PaginaWebResponseDTO {

    private int idacceso;
    private int idorden;
    private int ipcliente;
    private String useragent;
    private LocalDateTime fechaacceso;
    private String tipoacceso;

    public int getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(int idacceso) {
        this.idacceso = idacceso;
    }

    public int getIdorden() {
        return idorden;
    }

    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    public int getIpcliente() {
        return ipcliente;
    }

    public void setIpcliente(int ipcliente) {
        this.ipcliente = ipcliente;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    public LocalDateTime getFechaacceso() {
        return fechaacceso;
    }

    public void setFechaacceso(LocalDateTime fechaacceso) {
        this.fechaacceso = fechaacceso;
    }

    public String getTipoacceso() {
        return tipoacceso;
    }

    public void setTipoacceso(String tipoacceso) {
        this.tipoacceso = tipoacceso;
    }
}
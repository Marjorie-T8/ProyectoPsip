package com.uisrael.comusoapi.modelo.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HistorialEstadoResponseDTO {
    
    private Integer idHistorial;
    
    @JsonProperty("idorden")
    private Integer idOrden;
    
    @JsonProperty("estadoanterior")
    private String estadoAnterior;
    
    @JsonProperty("estadonuevo")
    private String estadoNuevo;
    
    @JsonProperty("fechacambio")
    private LocalDateTime fechaCambio;
    
    @JsonProperty("observacion")
    private String observacion;
    
    @JsonProperty("modificadopor")
    private String modificadoPor;
}
package com.uisrael.comusoapi.modelo.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MensajeClienteResponseDTO {
    
    private Integer idMensaje;
    
    @JsonProperty("idorden")
    private Integer idOrden;
    
    @JsonProperty("tipomensaje")
    private String tipoMensaje;
    
    @JsonProperty("medio")
    private String medio;
    
    @JsonProperty("destinatario")
    private String destinatario;
    
    @JsonProperty("contenido")
    private String contenido;
    
    @JsonProperty("fechaenvio")
    private LocalDateTime fechaEnvio;
    
    @JsonProperty("estadoenvio")
    private String estadoEnvio;
}
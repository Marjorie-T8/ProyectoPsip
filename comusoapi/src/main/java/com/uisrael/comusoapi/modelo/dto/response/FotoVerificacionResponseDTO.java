package com.uisrael.comusoapi.modelo.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FotoVerificacionResponseDTO {
    
    private Integer idFoto;
    
    @JsonProperty("idorden")
    private Integer idOrden;
    
    @JsonProperty("rutaarchivo")
    private String rutaArchivo;
    
    @JsonProperty("descripcion")
    private String descripcion;
    
    @JsonProperty("fecharegistro")
    private LocalDateTime fechaRegistro;
}
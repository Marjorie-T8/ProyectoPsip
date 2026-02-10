package com.uisrael.comusoapi.modelo.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AnexoDocumentoResponseDTO {
    
    private Integer idAnexo;
    
    @JsonProperty("idorden")
    private Integer idOrden;
    
    @JsonProperty("nombreoriginal")
    private String nombreOriginal;
    
    @JsonProperty("nombreguardado")
    private String nombreGuardado;
    
    @JsonProperty("tipomime")
    private String tipoMime;
    
    @JsonProperty("fechasubida")
    private LocalDateTime fechaSubida;
    
    @JsonProperty("estado")
    private Boolean estado;
}
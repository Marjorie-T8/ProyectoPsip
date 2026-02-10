package com.uisrael.comusoapi.modelo.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AnexoDocumentoRequestDTO {
    
    private Integer idAnexo;
    private Integer idOrden;
    private String nombreOriginal;
    private String nombreGuardado;
    private String tipoMime;
    private LocalDateTime fechaSubida;
    private Boolean estado;
}
package com.uisrael.comusoapi.modelo.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FotoVerificacionRequestDTO {
    
    private Integer idFoto;
    private Integer idOrden;
    private String rutaArchivo;
    private String descripcion;
    private LocalDateTime fechaRegistro;
}
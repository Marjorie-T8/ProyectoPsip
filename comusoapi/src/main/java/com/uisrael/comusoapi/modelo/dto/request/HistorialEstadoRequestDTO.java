package com.uisrael.comusoapi.modelo.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HistorialEstadoRequestDTO {
    
    private Integer idHistorial;
    private Integer idOrden;
    private String estadoAnterior;
    private String estadoNuevo;
    private LocalDateTime fechaCambio;
    private String observacion;
    private String modificadoPor;
}
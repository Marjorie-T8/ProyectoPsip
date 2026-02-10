package com.uisrael.comusoapi.modelo.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MensajeClienteRequestDTO {
    
    private Integer idMensaje;
    private Integer idOrden;
    private String tipoMensaje;
    private String medio;
    private String destinatario;
    private String contenido;
    private LocalDateTime fechaEnvio;
    private String estadoEnvio;
}
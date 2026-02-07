package com.uisrael.apipsip.presentacion.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MensajeClienteRequestDTO {

    private int idmensaje;

    @NotNull(message = "Debe vincular este mensaje a una orden de trabajo")
    private Integer idorden;

    @NotBlank(message = "El tipo de mensaje es obligatorio")
    private String tipomensaje;

    @NotBlank(message = "El medio de envío es obligatorio")
    private String medio;

    @NotBlank(message = "El destinatario es obligatorio")
    private String destinatario;

    @NotBlank(message = "El contenido del mensaje es obligatorio")
    private String contenido;

    @NotNull(message = "La fecha de envío es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaenvio;

    @NotBlank(message = "El estado de envío es obligatorio")
    private String estadoenvio;
}
package com.uisrael.apipsip.presentacion.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HistorialEstadoRequestDTO {

    private int idhistorial;

    @NotNull(message = "Debe vincular este historial a una orden de trabajo")
    private Integer idorden;

    @NotBlank(message = "El estado anterior es obligatorio")
    private String estadoanterior;

    @NotBlank(message = "El estado nuevo es obligatorio")
    private String estadonuevo;

    @NotNull(message = "La fecha de cambio es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechacambio;

    private String observacion;

    @NotBlank(message = "El usuario que modificó es obligatorio")
    private String modificadopor;
}
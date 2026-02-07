package com.uisrael.apipsip.presentacion.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FotoVerificacionRequestDTO {

    private int idfoto;

    @NotNull(message = "Debe vincular esta foto a una orden de trabajo")
    private Integer idorden;

    @NotBlank(message = "La ruta del archivo es obligatoria")
    private String rutaarchivo;

    @NotBlank(message = "La descripción de la foto es obligatoria")
    private String descripcion;

    @NotNull(message = "La fecha de registro es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fecharegistro;
}
package com.uisrael.apipsip.presentacion.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnexoDocumentosRequestDTO {

    private int idanexo;

    @NotNull(message = "Debe vincular este anexo a una orden de trabajo")
    private Integer idorden;

    @NotBlank(message = "El nombre original del archivo es obligatorio")
    private String nombreoriginal;

    @NotBlank(message = "El nombre guardado del archivo es obligatorio")
    private String nombreguardado;

    @NotBlank(message = "El tipo MIME del archivo es obligatorio")
    private String tipomime;

    @NotNull(message = "La fecha de subida es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechasubida;

    @NotNull(message = "El estado es obligatorio")
    private Boolean estado;
}
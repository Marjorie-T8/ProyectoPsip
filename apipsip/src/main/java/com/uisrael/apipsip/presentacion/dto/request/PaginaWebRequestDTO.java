package com.uisrael.apipsip.presentacion.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaginaWebRequestDTO {

    private int idacceso;

    @NotNull(message = "Debe vincular este acceso a una orden de trabajo")
    private Integer idorden;

    @NotNull(message = "La IP del cliente es obligatoria")
    private Integer ipcliente;

    @NotBlank(message = "El User-Agent es obligatorio")
    private String useragent;

    @NotNull(message = "La fecha de acceso es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaacceso;

    @NotBlank(message = "El tipo de acceso es obligatorio")
    private String tipoacceso;
}
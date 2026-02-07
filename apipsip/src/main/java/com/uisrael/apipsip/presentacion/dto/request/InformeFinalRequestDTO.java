package com.uisrael.apipsip.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class InformeFinalRequestDTO {

    private int idinforme;

    @NotNull(message = "La referencia a la orden de trabajo es obligatoria")
    private Integer idorden;

    @NotBlank(message = "El detalle final del trabajo es obligatorio")
    private String detallefinal;

    @NotNull(message = "El costo de repuestos es obligatorio (puede ser 0)")
    @PositiveOrZero(message = "El costo no puede ser negativo")
    private Double costorepuestos;

    @NotNull(message = "El costo de mano de obra es obligatorio")
    @PositiveOrZero(message = "El costo no puede ser negativo")
    private Double costomanodeobra;

    @NotNull(message = "El total es obligatorio")
    @PositiveOrZero(message = "El total no puede ser negativo")
    private Double total; 
}
package com.uisrael.apipsip.presentacion.dto.request;



import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EquipoRequestDTO {

    private int idEquipo; 
    @JsonProperty("idcliente")
    private int idCliente; 

    @NotBlank(message = "La marca es obligatoria")
    private String marca;

    @NotBlank(message = "El modelo es obligatorio")
    private String modelo;

  
    @NotBlank(message = "El número de serie es obligatorio")
    private String numserie;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

}

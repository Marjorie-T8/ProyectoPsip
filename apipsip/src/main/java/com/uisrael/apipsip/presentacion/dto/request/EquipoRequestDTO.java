package com.uisrael.apipsip.presentacion.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

 @Data
    public class EquipoRequestDTO {
        private int idequipo; 
        @JsonProperty("idcliente")
        private int idcliente; 
        @NotBlank(message = "El tipo de equipo es obligatorio (Laptop, PC, etc.)")
        private String tipo;
       @NotBlank(message = "La marca es obligatoria")
        private String marca;
        @NotBlank(message = "El modelo es obligatorio")
        private String modelo;
        @NotBlank(message = "El número de serie es obligatorio")
        private String numserie;
        @NotBlank(message = "El estado físico del equipo es obligatorio")
        private String estadoequipo; 
 }



package com.uisrael.apipsip.presentacion.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class ClienteRequestDTO {

	
	
	private Integer idCliente;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    private String email; 

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    private Boolean estado;
}


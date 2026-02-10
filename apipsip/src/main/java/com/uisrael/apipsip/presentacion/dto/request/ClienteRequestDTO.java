package com.uisrael.apipsip.presentacion.dto.request;


import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;


@Data
public class ClienteRequestDTO {

	
	
	private Integer idCliente;
	@NotBlank(message = "La cédula es obligatoria para evitar duplicados")
    private String cedula;

    @NotBlank(message = "El nombre es obligatorio")
    
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    private String email; 

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private LocalDate fechaNacimiento;
    private Boolean estado;
}


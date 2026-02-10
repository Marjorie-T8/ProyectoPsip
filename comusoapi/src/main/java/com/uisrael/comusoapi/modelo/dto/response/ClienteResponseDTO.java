package com.uisrael.comusoapi.modelo.dto.response;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class ClienteResponseDTO {
	private Integer idCliente;

    @JsonProperty("cedula") 
    private String cedula;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("email")
    private String email;

    @JsonProperty("telefono")
    private String telefono;


	private  LocalDate fechaNacimiento; 
	private Boolean estado;
}




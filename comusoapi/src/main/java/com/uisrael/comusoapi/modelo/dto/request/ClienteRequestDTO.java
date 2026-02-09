package com.uisrael.comusoapi.modelo.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClienteRequestDTO {
	
	private Integer idCliente;
	private String cedula;  
	private String nombre;
	private String email; 
	private  String telefono;
	private String direccion;
	private  LocalDate fechaNacimiento; 
	private Boolean estado;
	
}

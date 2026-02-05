package com.uisrael.comusoapi.modelo.dto.request;

import lombok.Data;

@Data
public class ClienteRequestDTO {
	
	private Integer idCliente;
	private String nombre;
	private String email; 
	private  String telefono;
	private String direccion;
	private Boolean estado;
	
}

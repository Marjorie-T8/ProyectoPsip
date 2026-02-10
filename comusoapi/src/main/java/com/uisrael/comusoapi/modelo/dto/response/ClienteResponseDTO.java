package com.uisrael.comusoapi.modelo.dto.response;
import java.time.LocalDate;

import lombok.Data;
@Data
public class ClienteResponseDTO {
	private int idCliente;
	private String cedula;  
	private String nombre;
	private String email; 
	private  String telefono;
	private String direccion;
	private  LocalDate fechaNacimiento; 
	private Boolean estado;
}



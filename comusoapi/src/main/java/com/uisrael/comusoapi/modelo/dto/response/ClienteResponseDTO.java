package com.uisrael.comusoapi.modelo.dto.response;
import lombok.Data;
@Data
public class ClienteResponseDTO {
    private int idCliente;
	private String nombre;
	private String email; 
	private  String telefono;
	private String direccion;
	private Boolean estado;	
}



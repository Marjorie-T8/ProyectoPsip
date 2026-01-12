package com.uisrael.apipsip.presentacion.dto.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class ClienteRequestDTO {

	@NotBlank
	private int idCliente;
	@NotBlank
	private String nombre;
	@NotBlank
	private String email; 
	@NotBlank
	private  String telefono;
	@NotBlank
	private String direccion;
	@NotBlank
	private boolean estado;
	
}

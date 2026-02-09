package com.uisrael.apipsip.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data

public class TecnicoRequestDTO {
	@NotBlank
	private int idTecnico;
	@NotBlank
	private  String nombre;
	@NotBlank
	private  String email;
	@NotBlank
	private String telefono;
	@NotBlank
	private boolean activo;

}

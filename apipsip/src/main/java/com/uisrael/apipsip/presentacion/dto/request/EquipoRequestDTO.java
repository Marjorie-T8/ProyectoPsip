package com.uisrael.apipsip.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EquipoRequestDTO {
	@NotBlank
	private  int idEquipo;
	@NotBlank
	private  String marca;
	@NotBlank
	private  String modelo;
	@NotBlank
	private  String numSerie;
	@NotBlank
	private String descripcion;

}

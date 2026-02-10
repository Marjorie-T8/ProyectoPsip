package com.uisrael.apipsip.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class TipoServicioRequestDTO {
	@NotBlank
	private int idTipo;
	@NotBlank
	private String nombre;
	@NotBlank
	private  String descripcion;
	private Boolean activo;

}

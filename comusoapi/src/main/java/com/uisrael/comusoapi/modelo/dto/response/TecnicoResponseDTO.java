package com.uisrael.comusoapi.modelo.dto.response;

import lombok.Data;

@Data
public class TecnicoResponseDTO {
	private int idTecnico;
	private  String nombre;
	private  String email;
	private String telefono;
	private boolean activo;
	

}

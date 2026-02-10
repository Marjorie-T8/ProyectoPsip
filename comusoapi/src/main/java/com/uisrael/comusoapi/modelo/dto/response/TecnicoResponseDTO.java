package com.uisrael.comusoapi.modelo.dto.response;

import lombok.Data;

@Data
public class TecnicoResponseDTO {
	private int idtecnico;
	private  String nombre;
	private String cedula;
	private  String email;	
	private String telefono;
	private Boolean activo;

}

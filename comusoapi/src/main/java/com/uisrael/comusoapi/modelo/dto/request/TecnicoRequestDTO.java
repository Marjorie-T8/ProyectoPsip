package com.uisrael.comusoapi.modelo.dto.request;

import lombok.Data;
@Data

public class TecnicoRequestDTO {

	private int idtecnico;
	private  String nombre;
	private String cedula;
	private String email;	
	private String telefono;
	private Boolean activo;

}

package com.uisrael.comusoapi.modelo.dto.request;

import lombok.Data;
@Data

public class TecnicoRequestDTO {

	private int idtecnico;
	private  String nombre;
	private  String email;
	private String telefono;
	private boolean activo;

}

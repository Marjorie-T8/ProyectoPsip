package com.uisrael.comusoapi.modelo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EquipoRequestDTO {
	private  Integer idEquipo;
	@JsonProperty("idcliente")
	private Integer idCliente; 	
	private  String marca;	
	private  String modelo;
	@JsonProperty("numserie")
	private  String numserie;	
	private String descripcion;
	private Boolean activo;
}

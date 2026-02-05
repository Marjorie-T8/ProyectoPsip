package com.uisrael.comusoapi.modelo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EquipoRequestDTO {
	private int idEquipo;
	@JsonProperty("idcliente")
    private int idCliente;
	private  String marca;
	private  String modelo;
	private  String numSerie;
	private String descripcion;

}

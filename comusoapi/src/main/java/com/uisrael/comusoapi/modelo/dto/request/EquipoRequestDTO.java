package com.uisrael.comusoapi.modelo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EquipoRequestDTO {
	
	 private int idequipo; 
	    @JsonProperty("idcliente")
	    private int idcliente;   
	    private String tipo; 
	    private String marca;	  
	    private String modelo;
	    @JsonProperty("numserie")
	    private String numserie;    
	    private String estadoequipo; 
	}



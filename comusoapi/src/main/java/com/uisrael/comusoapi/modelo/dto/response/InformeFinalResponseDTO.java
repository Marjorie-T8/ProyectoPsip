package com.uisrael.comusoapi.modelo.dto.response;

import lombok.Data;

@Data

public class InformeFinalResponseDTO {
	private int idinforme;  
    private Integer idorden;  
    private String detallefinal;
    private Double costorepuestos;
    private Double costomanodeobra;
    private Double total; 

}

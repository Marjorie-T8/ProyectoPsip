package com.uisrael.comusoapi.modelo.dto.request;


import lombok.Data;

@Data
public class InformeFinalRequestDTO {

    private int idinforme;  
    private Integer idorden;  
    private String detallefinal;
    private Double costorepuestos;
    private Double costomanodeobra;
    private Double total; 
}
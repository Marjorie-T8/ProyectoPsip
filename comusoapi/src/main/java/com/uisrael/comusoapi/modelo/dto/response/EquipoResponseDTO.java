package com.uisrael.comusoapi.modelo.dto.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class EquipoResponseDTO {

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

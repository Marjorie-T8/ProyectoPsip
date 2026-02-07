package com.uisrael.comusoapi.modelo.dto.response;


import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;
@Data
public class SolicitudServicioResponseDTO {
	
	    private int idsolicitud;
	    private String codigoticket; 
	    private int idcliente;
	    private int idequipo;
	    private String modalidadatencion;
	    private String direccionservicio; 
	    private LocalDate fechacita; 
	    private LocalTime horacita;
	    private String estado = "PENDIENTE"; 
}

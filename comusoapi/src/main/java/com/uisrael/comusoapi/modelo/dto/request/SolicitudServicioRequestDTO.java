package com.uisrael.comusoapi.modelo.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data
public class SolicitudServicioRequestDTO {
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
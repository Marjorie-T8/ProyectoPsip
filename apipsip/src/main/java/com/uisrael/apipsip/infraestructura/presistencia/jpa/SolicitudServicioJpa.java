package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "solicitudservicio")
public class SolicitudServicioJpa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idsolicitud;

    @Column(unique = true, nullable = false)
    private String codigoticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente", nullable = false)
    private ClienteJpa cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idequipo", nullable = false)
    private EquipoJpa equipo;

    private String modalidadatencion; 
    private String direccionservicio;
    private LocalDate fechacita;
    private LocalTime horacita;
    private String estado = "PENDIENTE";
}

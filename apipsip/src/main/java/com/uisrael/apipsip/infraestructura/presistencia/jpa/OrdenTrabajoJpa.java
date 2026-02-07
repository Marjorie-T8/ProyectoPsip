package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;
import lombok.Data;

    @Data
    @Entity
    @Table(name = "ordentrabajo")
    public class OrdenTrabajoJpa implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idorden")
        private int idorden;

        @Column(name = "codigo", unique = true, nullable = false)
        private String codigo;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idsolicitud", nullable = false)
        private SolicitudServicioJpa solicitud;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idcliente", nullable = false)
        private ClienteJpa cliente;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idtecnico")
        private TecnicoJpa tecnico;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idtipo")
        private TipoServicioJpa tipoServicio;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idequipo", nullable = false)
        private EquipoJpa equipo;

        @Column(name = "fechacreacion")
        private LocalDate fechacreacion; 

        @Column(name = "fechasolicitud")
        private LocalDate fechasolicitud; 

        @Column(name = "fechacita")
        private LocalDate fechacita;

        @Column(name = "horacita")
        private LocalTime horacita;

        @Column(name = "estado")
        private String estado;

        @Column(name = "numseriereal")
        private String numseriereal;

        @Column(name = "descripciontrabajo", columnDefinition = "TEXT")
        private String descripciontrabajo;

        @Column(name = "observaciones", columnDefinition = "TEXT")
        private String observaciones;
}

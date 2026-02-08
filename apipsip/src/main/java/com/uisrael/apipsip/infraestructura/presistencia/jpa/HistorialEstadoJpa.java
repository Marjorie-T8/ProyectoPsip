package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "historialestado")
public class HistorialEstadoJpa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhistorial")
    private int idhistorial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idorden", insertable = false, updatable = false)
    private OrdenTrabajoJpa ordenTrabajo;

    @Column(name = "idorden")
    private int idorden;

    @Column(name = "estadoanterior")
    private String estadoAnterior;

    @Column(name = "estadonuevo")
    private String estadoNuevo;

    @Column(name = "fechacambio")
    private LocalDateTime fechaCambio;

    private String observacion;

    @Column(name = "modificadopor")
    private String modificadoPor;
}
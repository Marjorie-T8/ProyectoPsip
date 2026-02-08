package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "informefinal")
public class InformeFinalJpa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idinforme;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idorden", nullable = false)
    private OrdenTrabajoJpa ordenTrabajo;
    @Column(columnDefinition = "TEXT")
    private String detallefinal;
    private double costorepuestos;
    private double costomanodeobra;
    private double total;
}

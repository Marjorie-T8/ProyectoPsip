package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "equipo")
public class EquipoJpa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idequipo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente", nullable = false)
    private ClienteJpa cliente; 
    private String tipo;
    private String marca;
    private String modelo;
    private String numserie;
    @Column(columnDefinition = "TEXT")
    private String estadoequipo;
}
package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tiposervicio")
public class TipoServicioJpa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo")
    private int idTipo;
    @Column(name = "nombre", unique = true, nullable = false, length = 100)
    private String nombre; 
    private String descripcion;
    private Boolean activo = true;
}
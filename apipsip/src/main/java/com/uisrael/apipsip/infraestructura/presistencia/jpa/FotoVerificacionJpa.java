package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fotoverificacion")
public class FotoVerificacionJpa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfoto")
    private int idfoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idorden", insertable = false, updatable = false)
    private OrdenTrabajoJpa ordenTrabajo;

    @Column(name = "idorden")
    private int idorden;

    @Column(name = "rutaarchivo")
    private String rutaArchivo;

    private String descripcion;

    @Column(name = "fecharegistro")
    private LocalDateTime fechaRegistro;
}
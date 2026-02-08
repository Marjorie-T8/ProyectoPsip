package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "anexodocumentos")
public class AnexoDocumentosJpa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idanexo")
    private int idanexo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idorden", insertable = false, updatable = false)
    private OrdenTrabajoJpa ordenTrabajo;

    @Column(name = "idorden")
    private int idorden;

    @Column(name = "nombreoriginal")
    private String nombreOriginal;

    @Column(name = "nombreguardado")
    private String nombreGuardado;

    @Column(name = "tipomime")
    private String tipoMime;

    @Column(name = "fechasubida")
    private LocalDateTime fechaSubida;

    private boolean estado;
}
package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mensajeciente")
public class MensajeClienteJpa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmensaje")
    private int idMensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idorden", insertable = false, updatable = false)
    private OrdenTrabajoJpa ordenTrabajo;

    @Column(name = "idorden")
    private int idOrden;

    @Column(name = "tipomensaje")
    private String tipoMensaje;

    private String medio;

    private String destinatario;

    private String contenido;

    @Column(name = "fechaenvio")
    private LocalDateTime fechaEnvio;

    @Column(name = "estadoenvio")
    private String estadoEnvio;
}
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
    private int idOrden;
	@Column(name = "codigo", unique = true)
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente", insertable = false, updatable = false)
    private ClienteJpa cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtecnico", insertable = false, updatable = false)
    private TecnicoJpa tecnico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipo", insertable = false, updatable = false)
    private TipoServicioJpa tipoServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idequipo", insertable = false, updatable = false)
    private EquipoJpa equipo;

    @Column(name = "idcliente")
    private int idCliente;

    @Column(name = "idtecnico")
    private int idTecnico;

    @Column(name = "idtipo")
    private int idTipoServicio;

    @Column(name = "idequipo")
    private int idEquipo;

    @Column(name = "fechasolicitud") 
    private LocalDate fechaSolicitud;

    @Column(name = "fechaagendada") 
    private LocalDate fechaCita;

    @Column(name = "horaagendada")  
    private LocalTime horaCita;

    private String estado;

    @Column(name = "descripciontrabajo") 
    private String descripcionTrabajo;

    private String observaciones;
    @Column(name = "activo")
    private Boolean activo = true;
}
	
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
    private Integer idOrden;
    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;      
   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente") 
    private ClienteJpa cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtecnico")
    private TecnicoJpa tecnico;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtiposervicio")
    private TipoServicioJpa tipoServicio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idequipo")
    private EquipoJpa equipo;
    @Column(name = "fechasolicitud")
    private LocalDate fechaSolicitud; 
    @Column(name = "fechacita")
    private LocalDate fechaCita; 
    @Column(name = "hora_cita")
    private LocalTime horaCita;    
   private String estado;
   @Column(name = "descripcion_trabajo", length = 1000)
    private String descripcionTrabajo; 
    @Column(name = "observaciones", length = 1000)
    private String observaciones;
    private Boolean activo;
}
	
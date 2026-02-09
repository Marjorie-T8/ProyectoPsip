package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "equipo")
public class EquipoJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idequipo")
	    private int idEquipo;
	    @Column(name = "idcliente", nullable = false)
	    private int idCliente;
	    private String marca;
	    private String modelo;
	    @Column(name = "numserie")
	    @JsonProperty("numserie")
	    private String numserie;
    private String descripcion;
}

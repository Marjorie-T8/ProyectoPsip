package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")


public class ClienteJpa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "idcliente")
    private Integer idCliente;
	@Column(nullable = false, unique = true, length = 10)
    private String cedula;
    @Column(length = 80, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(nullable = false)
    private String direccion;
    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;

    private Boolean estado= true; 
}

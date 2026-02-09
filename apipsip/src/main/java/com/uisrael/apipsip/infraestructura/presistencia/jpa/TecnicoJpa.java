package com.uisrael.apipsip.infraestructura.presistencia.jpa;


import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tecnico")
public class TecnicoJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtecnico")
	private int idTecnico;
	private String nombre;
	private String email;
	private String telefono;
	private boolean activo;
}

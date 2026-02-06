package com.uisrael.apipsip.infraestructura.presistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.uisrael.apipsip.dominio.entidades.OrdenTrabajo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "anexodocumentos")
public class AnexoDocumentosJpa implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int idAnexo;
	@Column(name = "idorden")
	private  OrdenTrabajoJpa ordenTrabajo;
	private  String nombreOriginal;
	private  String nombreGuardado;
	private  String tipoMime;
	private  LocalDateTime fechaSubida;
	private  boolean estado;

	
}

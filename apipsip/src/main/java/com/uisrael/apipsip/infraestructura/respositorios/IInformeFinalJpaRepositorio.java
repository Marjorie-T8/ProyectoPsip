package com.uisrael.apipsip.infraestructura.respositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.apipsip.infraestructura.presistencia.jpa.InformeFinalJpa;

public interface IInformeFinalJpaRepositorio extends JpaRepository<InformeFinalJpa, Integer> {
	
	Optional<InformeFinalJpa> findByOrdenIdorden(int idorden);
}

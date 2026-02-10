package com.uisrael.apipsip.infraestructura.respositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.OrdenTrabajoJpa;

public interface IOrdenTrabajoJpaRepositorio extends JpaRepository<OrdenTrabajoJpa, Integer> {
	Optional<OrdenTrabajoJpa> findByCodigo(String codigo);
}


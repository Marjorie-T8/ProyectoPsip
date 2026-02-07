package com.uisrael.apipsip.infraestructura.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.HistorialEstadoJpa;

public interface IHistorialEstadoJpaRepositorio extends JpaRepository<HistorialEstadoJpa, Integer> {
}
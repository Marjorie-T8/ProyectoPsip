package com.uisrael.apipsip.infraestructura.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.TecnicoJpa;

public interface ITecnicoJpaRepositorio extends JpaRepository<TecnicoJpa, Integer> {
}
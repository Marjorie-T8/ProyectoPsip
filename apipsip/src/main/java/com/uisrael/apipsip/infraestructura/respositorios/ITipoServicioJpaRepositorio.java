package com.uisrael.apipsip.infraestructura.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.TipoServicioJpa;

public interface ITipoServicioJpaRepositorio extends JpaRepository<TipoServicioJpa, Integer> {
}
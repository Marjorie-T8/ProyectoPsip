package com.uisrael.apipsip.infraestructura.respositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.uisrael.apipsip.infraestructura.presistencia.jpa.TipoServicioJpa;

public interface ITipoServicioJpaRepositorio extends JpaRepository<TipoServicioJpa, Integer> {
Optional<TipoServicioJpa> findByNombre(String nombre);
    List<TipoServicioJpa> findByActivoTrue();
}
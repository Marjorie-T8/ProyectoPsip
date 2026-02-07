package com.uisrael.apipsip.infraestructura.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.PaginaWebJpa;

public interface IPaginaWebJpaRepositorio extends JpaRepository<PaginaWebJpa, Integer> {
}
package com.uisrael.apipsip.infraestructura.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.MensajeClienteJpa;

public interface IMensajeClienteJpaRepositorio extends JpaRepository<MensajeClienteJpa, Integer> {
}
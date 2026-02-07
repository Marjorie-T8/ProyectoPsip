package com.uisrael.apipsip.infraestructura.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.FotoVerificacionJpa;

public interface IFotoVerificacionJpaRepositorio extends JpaRepository<FotoVerificacionJpa, Integer> {
}
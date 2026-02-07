package com.uisrael.apipsip.infraestructura.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.AnexoDocumentosJpa;

public interface IAnexoDocumentosJpaRepositorio extends JpaRepository<AnexoDocumentosJpa, Integer> {
}
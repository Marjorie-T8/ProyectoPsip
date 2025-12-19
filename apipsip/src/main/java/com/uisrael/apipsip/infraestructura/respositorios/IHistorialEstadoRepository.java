package com.uisrael.apipsip.infraestructura.respositorios;

import com.uisrael.apipsip.dominio.entidades.HistorialEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistorialEstadoRepository extends JpaRepository<HistorialEstado, Long> {
}
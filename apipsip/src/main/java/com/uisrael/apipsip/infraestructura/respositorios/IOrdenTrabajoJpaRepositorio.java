package com.uisrael.apipsip.infraestructura.respositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.OrdenTrabajoJpa;

public interface IOrdenTrabajoJpaRepositorio extends JpaRepository<OrdenTrabajoJpa, Integer> {
	@EntityGraph(attributePaths = {"cliente", "tecnico", "equipo", "tipoServicio"})
    Optional<OrdenTrabajoJpa> findById(Integer id);

    @EntityGraph(attributePaths = {"cliente", "tecnico", "equipo", "tipoServicio"})
    List<OrdenTrabajoJpa> findAll();
    Optional<OrdenTrabajoJpa> findByCodigo(String codigo);

}

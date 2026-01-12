package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.OrdenTrabajo;
import com.uisrael.apipsip.dominio.repositorios.IOrdenTrabajoRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.OrdenTrabajoJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.IOrdenTrabajoJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.IOrdenTrabajoJpaRepositorio;

public class OrdenTrabajoRepositorioImpl implements IOrdenTrabajoRepositorio {

    private final IOrdenTrabajoJpaRepositorio jpaRepository;
    private final IOrdenTrabajoJpaMapper entityMapper;

    public OrdenTrabajoRepositorioImpl(
            IOrdenTrabajoJpaRepositorio jpaRepository,
            IOrdenTrabajoJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public OrdenTrabajo guardar(OrdenTrabajo ordenTrabajo) {
        OrdenTrabajoJpa entity = entityMapper.toEntity(ordenTrabajo);
        OrdenTrabajoJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<OrdenTrabajo> buscarPorId(int id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<OrdenTrabajo> listarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public void eliminar(int id) {
        jpaRepository.deleteById(id);
    }
}

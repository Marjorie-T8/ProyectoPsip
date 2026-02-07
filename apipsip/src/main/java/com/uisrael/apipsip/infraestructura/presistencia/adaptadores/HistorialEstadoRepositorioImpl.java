package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.HistorialEstado;
import com.uisrael.apipsip.dominio.repositorios.IHistorialEstadoRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.HistorialEstadoJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.IHistorialEstadoJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.IHistorialEstadoJpaRepositorio;

public class HistorialEstadoRepositorioImpl implements IHistorialEstadoRepositorio {

    private final IHistorialEstadoJpaRepositorio jpaRepository;
    private final IHistorialEstadoJpaMapper entityMapper;

    public HistorialEstadoRepositorioImpl(
            IHistorialEstadoJpaRepositorio jpaRepository,
            IHistorialEstadoJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public HistorialEstado guardar(HistorialEstado historialEstado) {
        HistorialEstadoJpa entity = entityMapper.toEntity(historialEstado);
        HistorialEstadoJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<HistorialEstado> buscarPorId(int id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<HistorialEstado> listarTodos() {
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
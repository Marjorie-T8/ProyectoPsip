package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.Equipo;
import com.uisrael.apipsip.dominio.repositorios.IEquipoRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.EquipoJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.IEquipoJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.IEquipoJpaRepositorio;

public class EquipoRepositorioImpl implements IEquipoRepositorio {

    private final IEquipoJpaRepositorio jpaRepository;
    private final IEquipoJpaMapper entityMapper;

    public EquipoRepositorioImpl(
            IEquipoJpaRepositorio jpaRepository,
            IEquipoJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Equipo guardar(Equipo equipo) {
        EquipoJpa entity = entityMapper.toEntity(equipo);
        EquipoJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<Equipo> buscarPorId(int id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<Equipo> listarTodos() {
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
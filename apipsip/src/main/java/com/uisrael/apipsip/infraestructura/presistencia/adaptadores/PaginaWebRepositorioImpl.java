package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.PaginaWeb;
import com.uisrael.apipsip.dominio.repositorios.IPaginaWebRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.PaginaWebJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.IPaginaWebJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.IPaginaWebJpaRepositorio;

public class PaginaWebRepositorioImpl implements IPaginaWebRepositorio {

    private final IPaginaWebJpaRepositorio jpaRepository;
    private final IPaginaWebJpaMapper entityMapper;

    public PaginaWebRepositorioImpl(
            IPaginaWebJpaRepositorio jpaRepository,
            IPaginaWebJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public PaginaWeb guardar(PaginaWeb paginaWeb) {
        PaginaWebJpa entity = entityMapper.toEntity(paginaWeb);
        PaginaWebJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<PaginaWeb> buscarPorId(int id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<PaginaWeb> listarTodos() {
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
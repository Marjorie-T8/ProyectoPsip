package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;


import com.uisrael.apipsip.dominio.entidades.TipoServicio;
import com.uisrael.apipsip.dominio.repositorios.ITipoServicioRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.TipoServicioJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.ITipoServicioJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.ITipoServicioJpaRepositorio;

public class TipoServicioRepositorioImpl implements ITipoServicioRepositorio {

    private final ITipoServicioJpaRepositorio jpaRepository;
    private final ITipoServicioJpaMapper entityMapper;

    public TipoServicioRepositorioImpl(
            ITipoServicioJpaRepositorio jpaRepository,
            ITipoServicioJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public TipoServicio guardar(TipoServicio tiposervicio) {
        TipoServicioJpa entity = entityMapper.toEntity(tiposervicio);
        TipoServicioJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

  

    @Override
    public Optional<TipoServicio> buscarPorId(int id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<TipoServicio> listarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<TipoServicio> buscarPorNombre(String nombre) {
        return jpaRepository.findByNombre(nombre)
                .map(entityMapper::toDomain);
    }

    @Override
    public void eliminar(int id) {
      
        jpaRepository.deleteById(id);
    }
}

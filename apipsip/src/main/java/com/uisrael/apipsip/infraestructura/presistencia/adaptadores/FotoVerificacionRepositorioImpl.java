package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.FotoVerificacion;
import com.uisrael.apipsip.dominio.repositorios.IFotoVerificacionRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.FotoVerificacionJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.IFotoVerificacionJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.IFotoVerificacionJpaRepositorio;

public class FotoVerificacionRepositorioImpl implements IFotoVerificacionRepositorio {

    private final IFotoVerificacionJpaRepositorio jpaRepository;
    private final IFotoVerificacionJpaMapper entityMapper;

    public FotoVerificacionRepositorioImpl(
            IFotoVerificacionJpaRepositorio jpaRepository,
            IFotoVerificacionJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public FotoVerificacion guardar(FotoVerificacion fotoVerificacion) {
        FotoVerificacionJpa entity = entityMapper.toEntity(fotoVerificacion);
        FotoVerificacionJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<FotoVerificacion> buscarPorId(int id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<FotoVerificacion> listarTodos() {
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
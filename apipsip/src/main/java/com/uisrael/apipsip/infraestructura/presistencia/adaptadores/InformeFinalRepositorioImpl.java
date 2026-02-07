package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import com.uisrael.apipsip.dominio.entidades.InformeFinal;
import com.uisrael.apipsip.dominio.repositorios.IInformeFinalRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.InformeFinalJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.IInformeFinalJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.IInformeFinalJpaRepositorio;

public class InformeFinalRepositorioImpl implements IInformeFinalRepositorio {

    private final IInformeFinalJpaRepositorio jpaRepository;
    private final IInformeFinalJpaMapper entityMapper;

    public InformeFinalRepositorioImpl(IInformeFinalJpaRepositorio jpaRepository, IInformeFinalJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public InformeFinal guardar(InformeFinal informe) {
        InformeFinalJpa entity = entityMapper.toEntity(informe);
        InformeFinalJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<InformeFinal> Final(int id) {
        return jpaRepository.findById(id).map(entityMapper::toDomain);
    }
  
    @Override
    public List<InformeFinal> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public void eliminar(int id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public InformeFinal buscarPorOrden(int idOrden) {
        // Ya lo tienes bien aquí, llamando al método relacional
        return jpaRepository.findByOrdenIdorden(idOrden)
                .map(entityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Optional<InformeFinal> buscarPorIdOrden(int idOrden) {
    
        return jpaRepository.findByOrdenIdorden(idOrden)
                .map(entityMapper::toDomain);
    }
}
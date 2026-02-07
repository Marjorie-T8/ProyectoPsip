package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.AnexoDocumentos;
import com.uisrael.apipsip.dominio.repositorios.IAnexoDocumentosRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.AnexoDocumentosJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.IAnexoDocumentosJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.IAnexoDocumentosJpaRepositorio;

public class AnexoDocumentosRepositorioImpl implements IAnexoDocumentosRepositorio {

    private final IAnexoDocumentosJpaRepositorio jpaRepository;
    private final IAnexoDocumentosJpaMapper entityMapper;

    public AnexoDocumentosRepositorioImpl(
            IAnexoDocumentosJpaRepositorio jpaRepository,
            IAnexoDocumentosJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public AnexoDocumentos guardar(AnexoDocumentos anexoDocumentos) {
        AnexoDocumentosJpa entity = entityMapper.toEntity(anexoDocumentos);
        AnexoDocumentosJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<AnexoDocumentos> buscarPorId(int id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<AnexoDocumentos> listarTodos() {
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
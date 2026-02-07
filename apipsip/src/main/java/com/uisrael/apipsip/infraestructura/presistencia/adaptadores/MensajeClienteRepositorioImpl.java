package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.MensajeCliente;
import com.uisrael.apipsip.dominio.repositorios.IMensajeClienteRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.MensajeClienteJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.IMensajeClienteJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.IMensajeClienteJpaRepositorio;

public class MensajeClienteRepositorioImpl implements IMensajeClienteRepositorio {

    private final IMensajeClienteJpaRepositorio jpaRepository;
    private final IMensajeClienteJpaMapper entityMapper;

    public MensajeClienteRepositorioImpl(
            IMensajeClienteJpaRepositorio jpaRepository,
            IMensajeClienteJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public MensajeCliente guardar(MensajeCliente mensajeCliente) {
        MensajeClienteJpa entity = entityMapper.toEntity(mensajeCliente);
        MensajeClienteJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<MensajeCliente> buscarPorId(int id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<MensajeCliente> listarTodos() {
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
package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import com.uisrael.apipsip.dominio.entidades.SolicitudServicio;
import com.uisrael.apipsip.dominio.repositorios.ISolicitudServicioRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.SolicitudServicioJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.ISolicitudServicioJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.ISolicitudServicioJpaRepositorio;

public class SolicitudServicioRepositorioImpl implements ISolicitudServicioRepositorio {

    private final ISolicitudServicioJpaRepositorio jpaRepository;
    private final ISolicitudServicioJpaMapper entityMapper;

    public SolicitudServicioRepositorioImpl(ISolicitudServicioJpaRepositorio jpaRepository, ISolicitudServicioJpaMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public SolicitudServicio guardar(SolicitudServicio solicitud) {
        SolicitudServicioJpa entity = entityMapper.toEntity(solicitud);
        SolicitudServicioJpa guardado = jpaRepository.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<SolicitudServicio> buscarPorId(int id) {
        return jpaRepository.findById(id).map(entityMapper::toDomain);
    }

    // ESTE ES EL NOMBRE CORRECTO SEGÚN LA INTERFAZ
    @Override
    public Optional<SolicitudServicio> buscarPorCodigoTicket(String codigoTicket) {
        return jpaRepository.findByCodigoticket(codigoTicket).map(entityMapper::toDomain);
    }

    @Override
    public List<SolicitudServicio> listarTodas() {
        return jpaRepository.findAll().stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public void eliminar(int id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<SolicitudServicio> listarPorCliente(int idCliente) {
        return jpaRepository.findByClienteIdcliente(idCliente).stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public List<SolicitudServicio> listarPorIdCliente(int idCliente) {
        // No lo dejes como null, reutiliza la lógica que ya funciona
        return this.listarPorCliente(idCliente);
    }
}
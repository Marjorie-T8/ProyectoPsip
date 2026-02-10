package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IOrdenTrabajoUseCase;
import com.uisrael.apipsip.aplicacion.excepciones.RecursoDuplicadoException;
import com.uisrael.apipsip.dominio.entidades.OrdenTrabajo;
import com.uisrael.apipsip.dominio.repositorios.IOrdenTrabajoRepositorio;

public class OrdenTrabajoUseCaseImpl implements IOrdenTrabajoUseCase {

    private final IOrdenTrabajoRepositorio repositorio;

    public OrdenTrabajoUseCaseImpl(IOrdenTrabajoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public OrdenTrabajo crear(OrdenTrabajo ordenOriginal) {
       
        String nuevoCodigo = "OT-" + java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

        
        OrdenTrabajo ordenParaGuardar = new OrdenTrabajo(
            ordenOriginal.getIdOrden(),
            nuevoCodigo,         
            ordenOriginal.getIdCliente(),
            ordenOriginal.getIdTecnico(),
            ordenOriginal.getIdTipoServicio(),
            ordenOriginal.getIdEquipo(),
            ordenOriginal.getFechaSolicitud(),
            ordenOriginal.getFechaCita(),
            ordenOriginal.getHoraCita(),
            ordenOriginal.getEstado(),
            ordenOriginal.getDescripcionTrabajo(),
            ordenOriginal.getObservaciones(),
            ordenOriginal.getActivo()
        );

     
        return repositorio.guardar(ordenParaGuardar);
    }
    @Override
    public void eliminar(int id) {
        OrdenTrabajo ex = obtenerPorId(id);

     
        OrdenTrabajo inactiva = new OrdenTrabajo(
            ex.getIdOrden(), ex.getCodigo(), ex.getIdCliente(), ex.getIdTecnico(),
            ex.getIdTipoServicio(), ex.getIdEquipo(), ex.getFechaSolicitud(),
            ex.getFechaCita(), ex.getHoraCita(), ex.getEstado(),
            ex.getDescripcionTrabajo(), ex.getObservaciones(), 
            false 
        );
        repositorio.guardar(inactiva);
    }
    @Override
    public OrdenTrabajo obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Orden de trabajo no encontrada"));
    }

    @Override
    public List<OrdenTrabajo> listar() {
        return repositorio.listarTodos().stream()
                .filter(OrdenTrabajo::getActivo)
                .collect(Collectors.toList());
    }
   
    @Override
    public OrdenTrabajo actualizar(int id, OrdenTrabajo orden) {
        return repositorio.buscarPorId(id)
            .map(existente -> repositorio.guardar(orden))
            .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
    }
}

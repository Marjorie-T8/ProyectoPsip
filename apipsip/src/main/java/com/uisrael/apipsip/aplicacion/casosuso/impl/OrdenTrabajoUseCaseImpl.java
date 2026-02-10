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
            ordenOriginal.getCliente(),
            ordenOriginal.getTecnico(),
            ordenOriginal.getTipoServicio(),
            ordenOriginal.getEquipo(),
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
       
        OrdenTrabajo orden = obtenerPorId(id);
        OrdenTrabajo inactiva = new OrdenTrabajo(
            orden.getIdOrden(),
            orden.getCodigo(),
            orden.getCliente(),
            orden.getTecnico(),
            orden.getTipoServicio(),
            orden.getEquipo(),
            orden.getFechaSolicitud(),
            orden.getFechaCita(),
            orden.getHoraCita(),
            orden.getEstado(),
            orden.getDescripcionTrabajo(),
            orden.getObservaciones(),
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

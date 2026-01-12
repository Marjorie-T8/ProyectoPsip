package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IOrdenTrabajoUseCase;
import com.uisrael.apipsip.dominio.entidades.OrdenTrabajo;
import com.uisrael.apipsip.dominio.repositorios.IOrdenTrabajoRepositorio;

public class OrdenTrabajoUseCaseImpl implements IOrdenTrabajoUseCase {

    private final IOrdenTrabajoRepositorio repositorio;

    public OrdenTrabajoUseCaseImpl(IOrdenTrabajoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public OrdenTrabajo crear(OrdenTrabajo ordenTrabajo) {
        return repositorio.guardar(ordenTrabajo);
    }

    @Override
    public OrdenTrabajo obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Orden de trabajo no encontrada"));
    }

    @Override
    public List<OrdenTrabajo> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
}

package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IHistorialEstadoUseCase;
import com.uisrael.apipsip.dominio.entidades.HistorialEstado;
import com.uisrael.apipsip.dominio.repositorios.IHistorialEstadoRepositorio;

public class HistorialEstadoUseCaseImpl implements IHistorialEstadoUseCase {

    private final IHistorialEstadoRepositorio repositorio;

    public HistorialEstadoUseCaseImpl(IHistorialEstadoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public HistorialEstado crear(HistorialEstado historialEstado) {
        return repositorio.guardar(historialEstado);
    }

    @Override
    public HistorialEstado obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Historial de estado no encontrado"));
    }

    @Override
    public List<HistorialEstado> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }

    @Override
    public HistorialEstado actualizar(int id, HistorialEstado historial) {
        return repositorio.buscarPorId(id)
            .map(existente -> repositorio.guardar(historial))
            .orElseThrow(() -> new RuntimeException("Historial no encontrado"));
    }
}
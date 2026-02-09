package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.ITecnicoUseCase;
import com.uisrael.apipsip.dominio.entidades.Tecnico;
import com.uisrael.apipsip.dominio.repositorios.ITecnicoRepositorio;

public class TecnicoUseCaseImpl implements ITecnicoUseCase {

    private final ITecnicoRepositorio repositorio;

    public TecnicoUseCaseImpl(ITecnicoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Tecnico crear(Tecnico tecnico) {
        return repositorio.guardar(tecnico);
    }

    @Override
    public Tecnico obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Técnico no encontrado"));
    }

    @Override
    public List<Tecnico> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
    @Override
    public Tecnico actualizar(int id, Tecnico tecnico) {
        return repositorio.buscarPorId(id)
            .map(existente -> repositorio.guardar(tecnico))
            .orElseThrow(() -> new RuntimeException("Tecnico no encontrado"));
    }
}

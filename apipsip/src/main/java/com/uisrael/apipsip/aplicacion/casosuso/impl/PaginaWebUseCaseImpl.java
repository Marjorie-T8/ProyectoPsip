package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IPaginaWebUseCase;
import com.uisrael.apipsip.dominio.entidades.PaginaWeb;
import com.uisrael.apipsip.dominio.repositorios.IPaginaWebRepositorio;

public class PaginaWebUseCaseImpl implements IPaginaWebUseCase {

    private final IPaginaWebRepositorio repositorio;

    public PaginaWebUseCaseImpl(IPaginaWebRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public PaginaWeb crear(PaginaWeb paginaWeb) {
        return repositorio.guardar(paginaWeb);
    }

    @Override
    public PaginaWeb obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Página web no encontrada"));
    }

    @Override
    public List<PaginaWeb> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }

    @Override
    public PaginaWeb actualizar(int id, PaginaWeb pagina) {
        return repositorio.buscarPorId(id)
            .map(existente -> repositorio.guardar(pagina))
            .orElseThrow(() -> new RuntimeException("Página no encontrada"));
    }
}
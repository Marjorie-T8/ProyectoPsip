package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.ITipoServicioUseCase;
import com.uisrael.apipsip.dominio.entidades.TipoServicio;
import com.uisrael.apipsip.dominio.repositorios.ITipoServicioRepositorio;

public class TipoServicioUseCaseImpl implements ITipoServicioUseCase {

    private final ITipoServicioRepositorio repositorio;

    public TipoServicioUseCaseImpl(ITipoServicioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public TipoServicio crear(TipoServicio tipoServicio) {
        return repositorio.guardar(tipoServicio);
    }

    @Override
    public TipoServicio obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Tipo de servicio no encontrado"));
    }

    @Override
    public List<TipoServicio> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
}

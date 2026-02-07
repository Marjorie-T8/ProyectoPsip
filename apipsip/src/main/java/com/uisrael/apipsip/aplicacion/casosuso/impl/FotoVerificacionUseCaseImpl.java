package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IFotoVerificacionUseCase;
import com.uisrael.apipsip.dominio.entidades.FotoVerificacion;
import com.uisrael.apipsip.dominio.repositorios.IFotoVerificacionRepositorio;

public class FotoVerificacionUseCaseImpl implements IFotoVerificacionUseCase {

    private final IFotoVerificacionRepositorio repositorio;

    public FotoVerificacionUseCaseImpl(IFotoVerificacionRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public FotoVerificacion crear(FotoVerificacion fotoVerificacion) {
        return repositorio.guardar(fotoVerificacion);
    }

    @Override
    public FotoVerificacion obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Foto de verificación no encontrada"));
    }

    @Override
    public List<FotoVerificacion> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }

    @Override
    public FotoVerificacion actualizar(int id, FotoVerificacion foto) {
        return repositorio.buscarPorId(id)
            .map(existente -> repositorio.guardar(foto))
            .orElseThrow(() -> new RuntimeException("Foto no encontrada"));
    }
}
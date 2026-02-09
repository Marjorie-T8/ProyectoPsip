package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IEquipoUseCase;
import com.uisrael.apipsip.dominio.entidades.Equipo;
import com.uisrael.apipsip.dominio.repositorios.IEquipoRepositorio;

public class EquipoUseCaseImpl implements IEquipoUseCase {

    private final IEquipoRepositorio repositorio;

    public EquipoUseCaseImpl(IEquipoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Equipo crear(Equipo equipo) {
        return repositorio.guardar(equipo);
    }

    @Override
    public Equipo obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }

    @Override
    public List<Equipo> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }

    @Override
    public Equipo actualizar(int id, Equipo equipo) {
        return repositorio.buscarPorId(id)
            .map(existente -> repositorio.guardar(equipo))
            .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }

    @Override
    public List<Equipo> listarPorCliente(int idCliente) {
        return repositorio.listarPorCliente(idCliente);
    }
}

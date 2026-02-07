package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;
import com.uisrael.apipsip.aplicacion.casosuso.entradas.IInformeFinalUseCase;
import com.uisrael.apipsip.dominio.entidades.InformeFinal;
import com.uisrael.apipsip.dominio.repositorios.IInformeFinalRepositorio;

public class InformeFinalUseCaseImpl implements IInformeFinalUseCase {

    private final IInformeFinalRepositorio repositorio;

    public InformeFinalUseCaseImpl(IInformeFinalRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public InformeFinal guardar(InformeFinal informe) {
        return repositorio.guardar(informe);
    }

    @Override
    public InformeFinal obtenerPorId(int id) {
        return repositorio.Final(id)
                .orElseThrow(() -> new RuntimeException("Informe final no encontrado con ID: " + id));
    }

    @Override
    public InformeFinal obtenerPorIdOrden(int idOrden) {
        return repositorio.buscarPorIdOrden(idOrden)
                .orElseThrow(() -> new RuntimeException("No existe informe para la orden: " + idOrden));
    }

    @Override
    public List<InformeFinal> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
}
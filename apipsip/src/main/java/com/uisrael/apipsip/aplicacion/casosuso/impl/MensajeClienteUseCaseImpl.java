package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IMensajeClienteUseCase;
import com.uisrael.apipsip.dominio.entidades.MensajeCliente;
import com.uisrael.apipsip.dominio.repositorios.IMensajeClienteRepositorio;

public class MensajeClienteUseCaseImpl implements IMensajeClienteUseCase {

    private final IMensajeClienteRepositorio repositorio;

    public MensajeClienteUseCaseImpl(IMensajeClienteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public MensajeCliente crear(MensajeCliente mensajeCliente) {
        return repositorio.guardar(mensajeCliente);
    }

    @Override
    public MensajeCliente obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Mensaje de cliente no encontrado"));
    }

    @Override
    public List<MensajeCliente> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }

    @Override
    public MensajeCliente actualizar(int id, MensajeCliente mensaje) {
        return repositorio.buscarPorId(id)
            .map(existente -> repositorio.guardar(mensaje))
            .orElseThrow(() -> new RuntimeException("Mensaje no encontrado"));
    }
}
package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IAnexoDocumentosUseCase;
import com.uisrael.apipsip.dominio.entidades.AnexoDocumentos;
import com.uisrael.apipsip.dominio.repositorios.IAnexoDocumentosRepositorio;

public class AnexoDocumentosUseCaseImpl implements IAnexoDocumentosUseCase {

    private final IAnexoDocumentosRepositorio repositorio;

    public AnexoDocumentosUseCaseImpl(IAnexoDocumentosRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public AnexoDocumentos crear(AnexoDocumentos anexoDocumentos) {
        return repositorio.guardar(anexoDocumentos);
    }

    @Override
    public AnexoDocumentos obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Anexo de documentos no encontrado"));
    }

    @Override
    public List<AnexoDocumentos> listar() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }

    @Override
    public AnexoDocumentos actualizar(int id, AnexoDocumentos anexo) {
        return repositorio.buscarPorId(id)
            .map(existente -> repositorio.guardar(anexo))
            .orElseThrow(() -> new RuntimeException("Anexo no encontrado"));
    }
}
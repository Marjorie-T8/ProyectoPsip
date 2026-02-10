package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.ITipoServicioUseCase;
import com.uisrael.apipsip.aplicacion.excepciones.EntidadNoEncontradaException;
import com.uisrael.apipsip.aplicacion.excepciones.RecursoDuplicadoException;
import com.uisrael.apipsip.dominio.entidades.TipoServicio;
import com.uisrael.apipsip.dominio.repositorios.ITipoServicioRepositorio;

public class TipoServicioUseCaseImpl implements ITipoServicioUseCase {

    private final ITipoServicioRepositorio repositorio;

    public TipoServicioUseCaseImpl(ITipoServicioRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    public TipoServicio crear(TipoServicio ts) {
       
        if (repositorio.buscarPorNombre(ts.getNombre()).isPresent()) {
            throw new RecursoDuplicadoException("Este tipo de servicio ya existe.");
        }
        
        TipoServicio nuevoServicio = new TipoServicio(
            ts.getIdTipo(), 
            ts.getNombre(), 
            ts.getDescripcion(), 
            true 
        );
        return repositorio.guardar(nuevoServicio);
    }

    @Override
    public TipoServicio obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Tipo de servicio no encontrado"));
    }

    @Override
    public List<TipoServicio> listar() {
        
        return repositorio.listarTodos().stream()
                .filter(TipoServicio::getActivo)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(int id) {
 
        TipoServicio ex = obtenerPorId(id);
        
        TipoServicio inactivo = new TipoServicio(
            ex.getIdTipo(), 
            ex.getNombre(), 
            ex.getDescripcion(), 
            false 
        );
        
        repositorio.guardar(inactivo);
    }

    @Override
    public TipoServicio actualizar(int id, TipoServicio tipo) {
        return repositorio.buscarPorId(id)
            .map(existente -> {
                TipoServicio servicioParaGuardar = new TipoServicio(
                    id, tipo.getNombre(), tipo.getDescripcion(), tipo.getActivo()
                );
                return repositorio.guardar(servicioParaGuardar);
            })
            .orElseThrow(() -> new EntidadNoEncontradaException("Tipo de servicio no encontrado con ID: " + id));
    }
}


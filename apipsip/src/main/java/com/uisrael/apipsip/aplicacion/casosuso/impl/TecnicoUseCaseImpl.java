package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.ITecnicoUseCase;
import com.uisrael.apipsip.aplicacion.excepciones.EntidadNoEncontradaException;
import com.uisrael.apipsip.aplicacion.excepciones.RecursoDuplicadoException;
import com.uisrael.apipsip.dominio.entidades.Tecnico;
import com.uisrael.apipsip.dominio.repositorios.ITecnicoRepositorio;

public class TecnicoUseCaseImpl implements ITecnicoUseCase {

    private final ITecnicoRepositorio repositorio;

    public TecnicoUseCaseImpl(ITecnicoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Tecnico crear(Tecnico t) {
        
        if (repositorio.buscarPorCedula(t.getCedula()).isPresent()) {
            throw new RecursoDuplicadoException("La cédula ya pertenece a otro técnico.");
        }
 
        Tecnico nuevoTecnico = new Tecnico(
            t.getIdTecnico(), t.getNombre(), t.getCedula(), 
          t.getEmail(), t.getTelefono(), 
            true 
        );
        return repositorio.guardar(nuevoTecnico);
    }

    @Override
    public Tecnico obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Técnico no encontrado"));
    }

    @Override
    public List<Tecnico> listar() {
  
        return repositorio.listarTodos().stream()
                .filter(Tecnico::getActivo)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(int id) {
       
        Tecnico ex = obtenerPorId(id);
        
        Tecnico inactivo = new Tecnico(
            ex.getIdTecnico(), ex.getNombre(), ex.getCedula(), 
             ex.getEmail(), ex.getTelefono(), 
            false 
        );
        repositorio.guardar(inactivo);
    }

    @Override
    public Tecnico actualizar(int id, Tecnico t) {
        return repositorio.buscarPorId(id)
            .map(existente -> {
                Tecnico tecnicoParaGuardar = new Tecnico(
                    id, t.getNombre(), t.getCedula(), t.getEmail(), t.getTelefono(), t.getActivo()
                );
                return repositorio.guardar(tecnicoParaGuardar);
            })
            .orElseThrow(() -> new EntidadNoEncontradaException("Técnico no encontrado con ID: " + id));
    }
}
package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IEquipoUseCase;
import com.uisrael.apipsip.aplicacion.excepciones.EntidadNoEncontradaException;
import com.uisrael.apipsip.aplicacion.excepciones.RecursoDuplicadoException;
import com.uisrael.apipsip.dominio.entidades.Equipo;
import com.uisrael.apipsip.dominio.repositorios.IEquipoRepositorio;

public class EquipoUseCaseImpl implements IEquipoUseCase {

    private final IEquipoRepositorio repositorio;

    public EquipoUseCaseImpl(IEquipoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Equipo crear(Equipo equipo) {
       
        if (repositorio.buscarPorNumserie(equipo.getNumserie()).isPresent()) {
            throw new RecursoDuplicadoException("El número de serie ya existe");
        }

        Equipo equipoActivo = new Equipo(
            equipo.getIdEquipo(), 
            equipo.getIdCliente(), 
            equipo.getMarca(), 
            equipo.getModelo(), 
            equipo.getNumserie(), 
            equipo.getDescripcion(), 
            true 
        );

        return repositorio.guardar(equipoActivo);
    }

    @Override
    public void eliminar(int id) {
        Equipo ex = repositorio.buscarPorId(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Equipo no encontrado"));

        
        Equipo inactivo = new Equipo(
            ex.getIdEquipo(), 
            ex.getIdCliente(), 
            ex.getMarca(), 
            ex.getModelo(), 
            ex.getNumserie(), 
            ex.getDescripcion(), 
            false 
        );

        repositorio.guardar(inactivo);
    }

    @Override
    public List<Equipo> listar() {
        return repositorio.listarTodos().stream()
                .filter(Equipo::getActivo) 
                .collect(Collectors.toList());
    }

    @Override
    public Equipo actualizar(int id, Equipo equipo) {
        return repositorio.buscarPorId(id)
            .map(existente -> {
                Equipo equipoParaActualizar = new Equipo(
                    id, 
                    equipo.getIdCliente(),
                    equipo.getMarca(),
                    equipo.getModelo(),
                    equipo.getNumserie(),
                    equipo.getDescripcion(),
                    true 
                );
                return repositorio.guardar(equipoParaActualizar);
            })
            .orElseThrow(() -> new EntidadNoEncontradaException("Equipo no encontrado"));
    }
    @Override
    public List<Equipo> listarPorCliente(int idCliente) {
        return repositorio.listarPorCliente(idCliente);
    }
    @Override
    public Equipo obtenerPorId(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }
}

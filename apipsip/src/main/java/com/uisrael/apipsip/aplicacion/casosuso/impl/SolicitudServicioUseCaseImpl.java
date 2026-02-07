package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;
import com.uisrael.apipsip.aplicacion.casosuso.entradas.ISolicitudServicioUseCase;
import com.uisrael.apipsip.dominio.entidades.SolicitudServicio;
import com.uisrael.apipsip.dominio.repositorios.ISolicitudServicioRepositorio;

public class SolicitudServicioUseCaseImpl implements ISolicitudServicioUseCase {

    private final ISolicitudServicioRepositorio repositorio;

    public SolicitudServicioUseCaseImpl(ISolicitudServicioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public SolicitudServicio crear(SolicitudServicio solicitud) {
        return repositorio.guardar(solicitud);
    }

    @Override
    public SolicitudServicio obtenerPorId(int id) {
        // Recuerda que el repo de dominio devuelve Optional
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID: " + id));
    }

    
   @Override
    public SolicitudServicio obtenerPorCodigoTicket(String codigoTicket) {
        // Respetamos la búsqueda específica por ticket
        return repositorio.buscarPorCodigoTicket(codigoTicket)
                .orElseThrow(() -> new RuntimeException("Error: El ticket " + codigoTicket + " no existe."));
    }

    @Override
    public List<SolicitudServicio> listarPorCliente(int idCliente) {
        // Devolvemos la lista filtrada por cliente
        return repositorio.listarPorIdCliente(idCliente);
    }

    @Override
    public List<SolicitudServicio> listarTodas() {
        return repositorio.listarTodas();
    }

    @Override
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
}
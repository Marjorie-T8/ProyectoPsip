package com.uisrael.apipsip.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.SolicitudServicio;

public interface ISolicitudServicioRepositorio {
	SolicitudServicio guardar(SolicitudServicio solicitud);
    Optional<SolicitudServicio> buscarPorId(int id);

    Optional<SolicitudServicio> buscarPorCodigoTicket(String codigoTicket);
  
    List<SolicitudServicio> listarPorIdCliente(int idCliente);
    
    List<SolicitudServicio> listarTodas();
    void eliminar(int id);
    List<SolicitudServicio> listarPorCliente(int idCliente);
}

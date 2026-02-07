package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import java.util.List;
import com.uisrael.apipsip.dominio.entidades.SolicitudServicio;

public interface ISolicitudServicioUseCase {
   
    SolicitudServicio crear(SolicitudServicio solicitud);
    SolicitudServicio obtenerPorId(int id);
    SolicitudServicio obtenerPorCodigoTicket(String codigoTicket);
    List<SolicitudServicio> listarPorCliente(int idCliente);
    List<SolicitudServicio> listarTodas();
    void eliminar(int id);
}
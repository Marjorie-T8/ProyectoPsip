package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import com.uisrael.apipsip.dominio.entidades.FotoVerificacion;
import java.util.List;

public interface IFotoVerificacionUseCase {

    FotoVerificacion crear(FotoVerificacion fotoVerificacion);
    FotoVerificacion obtenerPorId(int id);
    List<FotoVerificacion> listar();
    void eliminar(int id);
    FotoVerificacion actualizar(int id, FotoVerificacion foto);
}
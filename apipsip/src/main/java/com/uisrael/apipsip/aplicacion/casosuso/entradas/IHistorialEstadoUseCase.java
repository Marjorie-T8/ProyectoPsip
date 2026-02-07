package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import com.uisrael.apipsip.dominio.entidades.HistorialEstado;
import java.util.List;

public interface IHistorialEstadoUseCase {

    HistorialEstado crear(HistorialEstado historialEstado);
    HistorialEstado obtenerPorId(int id);
    List<HistorialEstado> listar();
    void eliminar(int id);
    HistorialEstado actualizar(int id, HistorialEstado historial);
}
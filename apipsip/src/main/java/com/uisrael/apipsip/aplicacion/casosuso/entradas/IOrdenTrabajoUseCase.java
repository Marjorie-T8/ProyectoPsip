package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import com.uisrael.apipsip.dominio.entidades.OrdenTrabajo;
import java.util.List;

public interface IOrdenTrabajoUseCase {

    OrdenTrabajo crear(OrdenTrabajo ordenTrabajo);
    OrdenTrabajo obtenerPorId(int id);
    List<OrdenTrabajo> listar();
    void eliminar(int id);
    OrdenTrabajo actualizar(int id, OrdenTrabajo orden);
}

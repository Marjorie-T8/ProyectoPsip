package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import com.uisrael.apipsip.dominio.entidades.TipoServicio;
import java.util.List;

public interface ITipoServicioUseCase {

    TipoServicio crear(TipoServicio tipoServicio);
    TipoServicio obtenerPorId(int id);
    List<TipoServicio> listar();
    void eliminar(int id);
    TipoServicio actualizar(int id, TipoServicio tipoServicio);

}

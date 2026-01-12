package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import com.uisrael.apipsip.dominio.entidades.Equipo;
import java.util.List;

public interface IEquipoUseCase {

    Equipo crear(Equipo equipo);
    Equipo obtenerPorId(int id);
    List<Equipo> listar();
    void eliminar(int id);

}

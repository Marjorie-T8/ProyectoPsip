package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import com.uisrael.apipsip.dominio.entidades.Tecnico;
import java.util.List;

public interface ITecnicoUseCase {

    Tecnico crear(Tecnico tecnico);
    Tecnico obtenerPorId(int id);
    List<Tecnico> listar();
    void eliminar(int id);
    Tecnico actualizar(int id, Tecnico tecnico);
}

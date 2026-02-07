package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import com.uisrael.apipsip.dominio.entidades.PaginaWeb;
import java.util.List;

public interface IPaginaWebUseCase {

    PaginaWeb crear(PaginaWeb paginaWeb);
    PaginaWeb obtenerPorId(int id);
    List<PaginaWeb> listar();
    void eliminar(int id);
    PaginaWeb actualizar(int id, PaginaWeb pagina);
}
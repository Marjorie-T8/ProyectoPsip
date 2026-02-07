package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import java.util.List;
import com.uisrael.apipsip.dominio.entidades.InformeFinal;

public interface IInformeFinalUseCase {
   InformeFinal guardar(InformeFinal informe);
   InformeFinal obtenerPorId(int id);
   InformeFinal obtenerPorIdOrden(int idOrden);    
    List<InformeFinal> listarTodos();
    void eliminar(int id);
}
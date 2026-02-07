package com.uisrael.apipsip.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.InformeFinal;

public interface IInformeFinalRepositorio {
	InformeFinal guardar(InformeFinal informe);    
    Optional<InformeFinal> Final(int id);
 
    List<InformeFinal> listarTodos();   
    void eliminar(int id);
    InformeFinal buscarPorOrden(int idOrden); 
    Optional<InformeFinal> buscarPorIdOrden(int idOrden);
}

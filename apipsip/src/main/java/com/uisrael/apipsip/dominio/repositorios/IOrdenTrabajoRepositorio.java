package com.uisrael.apipsip.dominio.repositorios;



import java.util.List;
import java.util.Optional;


import com.uisrael.apipsip.dominio.entidades.OrdenTrabajo;

public interface IOrdenTrabajoRepositorio {
	OrdenTrabajo guardar(OrdenTrabajo ordentrabajo);
	Optional<OrdenTrabajo> buscarPorId(int id);
	List<OrdenTrabajo> listarTodos();
	void eliminar(int id);
	Optional<OrdenTrabajo> buscarPorCodigo(String codigo);

}


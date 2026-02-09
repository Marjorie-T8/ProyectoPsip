package com.uisrael.apipsip.dominio.repositorios;



import java.util.List;
import java.util.Optional;


import com.uisrael.apipsip.dominio.entidades.TipoServicio;

public interface ITipoServicioRepositorio {
	TipoServicio guardar(TipoServicio tiposervicio);
	Optional<TipoServicio> buscarPorId(int id);
	List<TipoServicio> listarTodos();
	void eliminar(int id);

}


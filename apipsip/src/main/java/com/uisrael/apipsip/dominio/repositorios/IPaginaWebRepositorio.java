package com.uisrael.apipsip.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.PaginaWeb;

public interface IPaginaWebRepositorio {
	PaginaWeb guardar(PaginaWeb paginaWeb);
	Optional<PaginaWeb> buscarPorId(int id);
	List<PaginaWeb> listarTodos();
	void eliminar(int id);
}
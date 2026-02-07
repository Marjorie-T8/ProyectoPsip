package com.uisrael.apipsip.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.HistorialEstado;

public interface IHistorialEstadoRepositorio {
	HistorialEstado guardar(HistorialEstado historialEstado);
	Optional<HistorialEstado> buscarPorId(int id);
	List<HistorialEstado> listarTodos();
	void eliminar(int id);
}
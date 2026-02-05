package com.uisrael.apipsip.dominio.repositorios;


import java.util.List;
import java.util.Optional;


import com.uisrael.apipsip.dominio.entidades.Equipo;

public interface IEquipoRepositorio {
	Equipo guardar(Equipo equipo);
	Optional<Equipo> buscarPorId(int id);
	List<Equipo> listarTodos();
	void eliminar(int id);
	List<Equipo> listarPorCliente(int idCliente);
	Equipo actualizar(int id, Equipo equipo);
}


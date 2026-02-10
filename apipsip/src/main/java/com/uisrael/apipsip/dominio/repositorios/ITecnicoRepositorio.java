package com.uisrael.apipsip.dominio.repositorios;



import java.util.List;
import java.util.Optional;


import com.uisrael.apipsip.dominio.entidades.Tecnico;

public interface ITecnicoRepositorio {
	Tecnico guardar(Tecnico tecnico);
	Optional<Tecnico> buscarPorId(int id);
	List<Tecnico> listarTodos();
	void eliminar(int id);
	Optional<Tecnico> buscarPorCedula(String cedula);

}




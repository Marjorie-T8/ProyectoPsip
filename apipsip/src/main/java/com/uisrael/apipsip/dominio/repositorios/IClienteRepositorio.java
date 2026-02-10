package com.uisrael.apipsip.dominio.repositorios;


import java.util.List;
import java.util.Optional;


import com.uisrael.apipsip.dominio.entidades.Cliente;

public interface IClienteRepositorio {
	Cliente guardar(Cliente cliente);
	Optional<Cliente> buscarPorId(int id);
	List<Cliente> listarTodos();
	void eliminar(int id);
	Cliente actualizar(int id, Cliente cliente);
	Optional<Cliente> buscarPorCedula(String cedula);
}

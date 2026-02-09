package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.apipsip.dominio.entidades.Cliente;

public interface IClienteUseCase {
	
	Cliente crear(Cliente cliente);
	Cliente obtenerPorId(int id);
	List<Cliente> listar();
	void eliminar (int id);
	
	Cliente actualizar(int id, Cliente cliente);
}

package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IClienteUseCase;
import com.uisrael.apipsip.dominio.entidades.Cliente;
import com.uisrael.apipsip.dominio.repositorios.IClienteRepositorio;

public class ClienteUseCaseImpl implements IClienteUseCase{
	private final IClienteRepositorio repositorio;
	

	public ClienteUseCaseImpl(IClienteRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Cliente crear(Cliente cliente) {
		return repositorio.guardar(cliente);
	}

	@Override
	public Cliente obtenerPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<Cliente> listar() {
		
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}

}

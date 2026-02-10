package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IClienteUseCase;
import com.uisrael.apipsip.aplicacion.excepciones.ClienteDuplicadoException;
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
	    if (repositorio.buscarPorCedula(cliente.getCedula()).isPresent()) {
	    
	        throw new ClienteDuplicadoException("La cédula ya está registrada.");
	    }
	    return repositorio.guardar(cliente);
	}
	@Override
	public Cliente obtenerPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
	}

	@Override
    public List<Cliente> listar() {
      
        return repositorio.listarTodos().stream()
                .filter(Cliente::getEstado) 
                .collect(Collectors.toList());
    }

	@Override
    public void eliminar(int id) {
        // REGLA: Borrado lógico (No usamos el delete del repo)
        Cliente existente = repositorio.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Creamos una nueva entidad igual pero con estado false
        Cliente inactivo = new Cliente(
            existente.getIdCliente(), existente.getCedula(), existente.getNombre(),
            existente.getEmail(), existente.getTelefono(), existente.getDireccion(),
            existente.getFechaNacimiento(), false // <-- Aquí se pone inactivo
        );

        repositorio.guardar(inactivo);
    }

	@Override
	public Cliente actualizar(int id, Cliente cliente) {
		return repositorio.buscarPorId(id)
		        .map(existente -> repositorio.guardar(cliente))
		        .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
		}
}

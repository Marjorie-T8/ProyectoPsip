package com.uisrael.apipsip.aplicacion.casosuso.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IClienteUseCase;
import com.uisrael.apipsip.aplicacion.excepciones.EntidadNoEncontradaException;
import com.uisrael.apipsip.aplicacion.excepciones.RecursoDuplicadoException;
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
            throw new RecursoDuplicadoException("La cédula ya está registrada.");
        }
        return repositorio.guardar(cliente);
    }

    @Override
    public Cliente obtenerPorId(int id) {
        Cliente cliente = repositorio.buscarPorId(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("CLIENTE NO ENCONTRADO"));

        if (!cliente.getEstado()) {
            throw new EntidadNoEncontradaException("CLIENTE ELIMINADO");
        }
        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        return repositorio.listarTodos().stream()
                .filter(Cliente::getEstado)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(int id) {
        Cliente existente = repositorio.buscarPorId(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("CLIENTE NO ENCONTRADO"));

        if (!existente.getEstado()) return;

        Cliente inactivo = new Cliente(
            existente.getIdCliente(),
            existente.getCedula(),
            existente.getNombre(),
            existente.getEmail(),
            existente.getTelefono(),
            existente.getDireccion(),
            existente.getFechaNacimiento(),
            false
        );
        repositorio.guardar(inactivo);
    }

    @Override
   
    public Cliente actualizar(Integer id, Cliente cliente) {
       
        Cliente existente = repositorio.buscarPorId(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Cliente no encontrado con ID: " + id));

       
        repositorio.buscarPorCedula(cliente.getCedula()).ifPresent(c -> {
            if (!c.getIdCliente().equals(id)) {
                throw new RecursoDuplicadoException("La cédula ya pertenece a otro cliente.");
            }
        });

       
        Cliente clienteParaGuardar = new Cliente(
            id, 
            cliente.getCedula(),
            cliente.getNombre(),
            cliente.getEmail(),
            cliente.getTelefono(),
            cliente.getDireccion(),
            cliente.getFechaNacimiento(),
            cliente.getEstado()
        );

       
        return repositorio.guardar(clienteParaGuardar);
    }

	
}
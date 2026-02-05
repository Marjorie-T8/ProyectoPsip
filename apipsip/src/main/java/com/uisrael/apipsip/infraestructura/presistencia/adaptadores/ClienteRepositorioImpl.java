package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;

import java.util.List;
import java.util.Optional;



import com.uisrael.apipsip.dominio.entidades.Cliente;
import com.uisrael.apipsip.dominio.repositorios.IClienteRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.ClienteJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.IClienteJpaRepositorio;

public class ClienteRepositorioImpl implements IClienteRepositorio{

	private final IClienteJpaRepositorio jpaRepository;
	private final IClienteJpaMapper entityMapper;

	public ClienteRepositorioImpl(IClienteJpaRepositorio jpaRepository, IClienteJpaMapper entityMapper) {
		super();
		this.jpaRepository = jpaRepository;
		this.entityMapper = entityMapper;
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		ClienteJpa entity = entityMapper.toEntity(cliente);
		ClienteJpa guardado = jpaRepository.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Cliente> buscarPorId(int id) {
		
		return jpaRepository.findById(id).map(entityMapper:: toDomain);
	}

	@Override
	public List<Cliente> listarTodos() {
		
		return jpaRepository.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepository.deleteById(id);
		
	}
	

	@Override
	public Cliente actualizar(int id, Cliente cliente) {
	    
	    ClienteJpa entity = entityMapper.toEntity(cliente);
	  
	    entity.setIdCliente(id); 
	    ClienteJpa guardado = jpaRepository.save(entity);
	    
	    return entityMapper.toDomain(guardado);
	}

}

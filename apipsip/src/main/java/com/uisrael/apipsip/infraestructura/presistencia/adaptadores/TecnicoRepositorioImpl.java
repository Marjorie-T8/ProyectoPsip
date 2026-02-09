package com.uisrael.apipsip.infraestructura.presistencia.adaptadores;


import java.util.List;
import java.util.Optional;
import com.uisrael.apipsip.dominio.entidades.Tecnico;
import com.uisrael.apipsip.dominio.repositorios.ITecnicoRepositorio;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.TecnicoJpa;
import com.uisrael.apipsip.infraestructura.presistencia.mapeadores.ITecnicoJpaMapper;
import com.uisrael.apipsip.infraestructura.respositorios.ITecnicoJpaRepositorio;




public class  TecnicoRepositorioImpl implements ITecnicoRepositorio{

	private final ITecnicoJpaRepositorio jpaRepository;
	private final ITecnicoJpaMapper entityMapper;

	


	public TecnicoRepositorioImpl(ITecnicoJpaRepositorio jpaRepository, ITecnicoJpaMapper entityMapper) {
		super();
		this.jpaRepository = jpaRepository;
		this.entityMapper = entityMapper;
	}

	@Override
	public Tecnico guardar(Tecnico tecnico) {
		TecnicoJpa entity = entityMapper.toEntity(tecnico);
		TecnicoJpa guardado = jpaRepository.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Tecnico> buscarPorId(int id) {
		
		return jpaRepository.findById(id).map(entityMapper:: toDomain);
	}

	@Override
	public List<Tecnico> listarTodos() {
		
		return jpaRepository.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepository.deleteById(id);
		
	}

}

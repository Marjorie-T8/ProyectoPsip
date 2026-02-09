package com.uisrael.apipsip.infraestructura.respositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.apipsip.infraestructura.presistencia.jpa.ClienteJpa;

public interface IClienteJpaRepositorio extends JpaRepository<ClienteJpa, Integer>{
	
	Optional<ClienteJpa> findByCedula(String cedula);

}
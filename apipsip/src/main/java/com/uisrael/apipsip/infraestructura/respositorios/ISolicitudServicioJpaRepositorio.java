package com.uisrael.apipsip.infraestructura.respositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.apipsip.infraestructura.presistencia.jpa.SolicitudServicioJpa;

public interface ISolicitudServicioJpaRepositorio extends JpaRepository<SolicitudServicioJpa, Integer>{
	
    Optional<SolicitudServicioJpa> findByCodigoticket(String codigoticket);
    List<SolicitudServicioJpa> findByClienteIdcliente(int idcliente);
}

package com.uisrael.apipsip.infraestructura.respositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.TecnicoJpa;

public interface ITecnicoJpaRepositorio extends JpaRepository<TecnicoJpa, Integer> {
Optional<TecnicoJpa> findByCedula(String cedula);  
    List<TecnicoJpa> findByActivoTrue(); 
    
}
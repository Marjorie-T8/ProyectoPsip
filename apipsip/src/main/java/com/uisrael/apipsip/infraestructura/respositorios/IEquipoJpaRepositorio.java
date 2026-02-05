package com.uisrael.apipsip.infraestructura.respositorios;



import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.apipsip.infraestructura.presistencia.jpa.EquipoJpa;

public interface IEquipoJpaRepositorio extends JpaRepository<EquipoJpa, Integer> {

}
package com.uisrael.apipsip.infraestructura.respositorios;

import com.uisrael.apipsip.dominio.entidades.PaginaWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaginaWebJpaRepositorio extends JpaRepository<PaginaWeb, Long> {
}
package com.uisrael.apipsip.infraestructura.repositorios;

import com.uisrael.apipsip.dominio.entidades.PaginaWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaginaWebRepository extends JpaRepository<PaginaWeb, Long> {
}
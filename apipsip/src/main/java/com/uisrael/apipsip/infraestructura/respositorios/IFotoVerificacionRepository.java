package com.uisrael.apipsip.infraestructura.repositorios;

import com.uisrael.apipsip.dominio.entidades.FotoVerificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFotoVerificacionRepository extends JpaRepository<FotoVerificacion, Long> {
}
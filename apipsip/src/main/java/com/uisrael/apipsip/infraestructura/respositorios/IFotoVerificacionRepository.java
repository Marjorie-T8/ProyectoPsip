package com.uisrael.apipsip.infraestructura.respositorios;

import com.uisrael.apipsip.dominio.entidades.FotoVerificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFotoVerificacionRepository extends JpaRepository<FotoVerificacion, Long> {
}
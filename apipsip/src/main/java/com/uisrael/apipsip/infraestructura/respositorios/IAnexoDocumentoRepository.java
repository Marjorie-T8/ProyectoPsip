package com.uisrael.apipsip.infraestructura.respositorios;

import com.uisrael.apipsip.dominio.entidades.AnexoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnexoDocumentoRepository extends JpaRepository<AnexoDocumento, Long> {
}
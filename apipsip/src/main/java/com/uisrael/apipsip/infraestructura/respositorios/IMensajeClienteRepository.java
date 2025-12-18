package com.uisrael.apipsip.infraestructura.repositorios;

import com.uisrael.apipsip.dominio.entidades.MensajeCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMensajeClienteRepository extends JpaRepository<MensajeCliente, Long> {
}
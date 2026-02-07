package com.uisrael.comusoapi.service;

import java.util.List;

import com.uisrael.comusoapi.modelo.dto.request.OrdenTrabajoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.OrdenTrabajoResponseDTO;

public interface IOrdenTrabajoServicio {
	
    List<OrdenTrabajoResponseDTO> listarOrdenesTrabajo();


    void crearOrdenTrabajo(OrdenTrabajoRequestDTO dto);


    OrdenTrabajoResponseDTO buscarOrdenTrabajoPorId(int id);


    void actualizarOrdenTrabajo(OrdenTrabajoRequestDTO dto);


    void eliminarOrdenTrabajo(int id);
    OrdenTrabajoResponseDTO buscarPorCodigoTicket(String codigo);
}



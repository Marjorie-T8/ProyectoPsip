package com.uisrael.comusoapi.service;

import java.util.List;

import com.uisrael.comusoapi.modelo.dto.response.SolicitudServicioResponseDTO;

public interface ISolicitudServicioServicio {
	String agendar(int idEquipo, String fecha, String hora, String modalidad);
	List<SolicitudServicioResponseDTO> listarTodas();
}

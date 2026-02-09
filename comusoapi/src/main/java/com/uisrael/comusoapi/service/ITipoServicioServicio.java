package com.uisrael.comusoapi.service;

import java.util.List;

import com.uisrael.comusoapi.modelo.dto.request.TipoServicioRequestDTO;

import com.uisrael.comusoapi.modelo.dto.response.TipoServicioResponseDTO;

public interface ITipoServicioServicio {

  
public List<TipoServicioResponseDTO> listarTipoServicio();
public void crearTipoServicio(TipoServicioRequestDTO dto);
public TipoServicioResponseDTO buscarTipoServicioPorId(int id);

}

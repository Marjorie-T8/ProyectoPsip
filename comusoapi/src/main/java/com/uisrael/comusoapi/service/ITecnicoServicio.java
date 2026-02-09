package com.uisrael.comusoapi.service;

import java.util.List;

import com.uisrael.comusoapi.modelo.dto.request.TecnicoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.TecnicoResponseDTO;

public interface ITecnicoServicio {

    
    public void crearTecnico(TecnicoRequestDTO dto); 
    public TecnicoResponseDTO buscarTecnicoPorId(int id); 
    public void actualizarTecnico(TecnicoRequestDTO dto);  
    public void eliminarTecnico(int id);
    List<TecnicoResponseDTO> listarTecnico();
}

package com.uisrael.comusoapi.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.comusoapi.modelo.dto.request.TecnicoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.request.TipoServicioRequestDTO;
@Controller
public class NavegacionControlador {
	@GetMapping("/gestion-sistema")
	public String index(Model model) {
	    model.addAttribute("nombrePagina", "REGISTRO RÁPIDO DE TÉCNICOS Y SERVICIOS");
	    model.addAttribute("tecnicoDTO", new TecnicoRequestDTO());
	    model.addAttribute("tipoServicioDTO", new TipoServicioRequestDTO());
	    
	   
	    return "tecnicoservicio/tecnicoservicio"; 
	}
}

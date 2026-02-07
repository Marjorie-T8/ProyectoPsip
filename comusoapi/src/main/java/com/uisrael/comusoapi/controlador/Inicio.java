package com.uisrael.comusoapi.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Inicio{//http://localhost:8081/inicio

	@GetMapping({"/", "/inicio"}) // Acepta ambas rutas
    public String index() {
        return "Inicio"; 
    }
 
   
}
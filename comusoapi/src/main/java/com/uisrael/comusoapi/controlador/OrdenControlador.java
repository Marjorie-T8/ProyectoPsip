package com.uisrael.comusoapi.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orden")
public class OrdenControlador {

    @GetMapping("/nueva")
    public String nuevaorden() {
        return "orden/nuevaorden"; 
    }


    @GetMapping("/listar")
    public String listarorden() {
        return "orden/listarorden"; 
    }

   
}
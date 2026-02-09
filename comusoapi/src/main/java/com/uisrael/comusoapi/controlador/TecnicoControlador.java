package com.uisrael.comusoapi.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.uisrael.comusoapi.modelo.dto.request.TecnicoRequestDTO;

import com.uisrael.comusoapi.service.ITecnicoServicio;

@Controller
@RequestMapping("/tecnico")
public class TecnicoControlador {

    @Autowired
    private ITecnicoServicio servicioTecnico;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("nombrePagina", "LISTADO DE TÉCNICOS - ICPE S.A.S.");
        model.addAttribute("listatecnicos", servicioTecnico.listarTecnico());
        return "tecnico/listartecnico"; 
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("nombrePagina", "REGISTRAR NUEVO TÉCNICO");
        model.addAttribute("tecnicoDTO", new TecnicoRequestDTO());
        return "tecnico/nuevotecnico";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("tecnicoDTO") TecnicoRequestDTO dto) {
        servicioTecnico.crearTecnico(dto);
        return "redirect:/tecnico/listar";
    }
}
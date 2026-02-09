package com.uisrael.comusoapi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uisrael.comusoapi.modelo.dto.request.TipoServicioRequestDTO;
import com.uisrael.comusoapi.service.ITipoServicioServicio;


@Controller
@RequestMapping("/tiposervicio")
public class TipoServicioControlador {

    @Autowired
    private ITipoServicioServicio servicioTipo;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("nombrePagina", "GESTIÓN DE SERVICIOS - ICPE S.A.S.");
        model.addAttribute("listaservicios", servicioTipo.listarTipoServicio());
        return "tiposervicio/listarservicio";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("nombrePagina", "AGREGAR CATEGORÍA DE SERVICIO");
        model.addAttribute("tipoServicioDTO", new TipoServicioRequestDTO());
        return "tiposervicio/nuevoservicio";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("tipoServicioDTO") TipoServicioRequestDTO dto) {
        servicioTipo.crearTipoServicio(dto);
        return "redirect:/tiposervicio/listar";
    }
}
package com.uisrael.comusoapi.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.comusoapi.modelo.dto.request.EquipoRequestDTO;
import com.uisrael.comusoapi.service.IEquipoServicio;

@Controller
@RequestMapping("/equipo")
public class EquipoControlador {

    @Autowired
    private IEquipoServicio servicioEquipo;

    // 1. Listar equipos (Ruta: equipo/listarequipos.html)
    @GetMapping("/listarPorCliente/{id}")
    public String listarPorCliente(@PathVariable int id, Model model) {
        model.addAttribute("listaequipos", servicioEquipo.listarEquiposPorCliente(id));
        model.addAttribute("idCliente", id);
        return "equipo/listarequipos"; // Nombre exacto de tu archivo
    }

    // 2. Formulario para nuevo equipo (Ruta: equipo/nuevoequipo.html)
    @GetMapping("/nuevo")
    public String nuevoEquipo(@RequestParam(name = "idCliente") int idCliente, Model model) {
        EquipoRequestDTO equipoDTO = new EquipoRequestDTO();
        equipoDTO.setIdCliente(idCliente); // Importante para que el formulario sepa de quién es el equipo
        
        model.addAttribute("idCliente", idCliente);
        model.addAttribute("equipoDTO", equipoDTO);
        return "equipo/nuevoequipo"; // Nombre exacto de tu archivo
    }

    // 3. Guardar y regresar a la lista de equipos del cliente
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("equipoDTO") EquipoRequestDTO equipoDTO) {
        servicioEquipo.crearEquipo(equipoDTO);
        // Redirigimos a la lista de equipos para ver el equipo recién creado
        return "redirect:/equipo/listarPorCliente/" + equipoDTO.getIdCliente();
    }
}
package com.uisrael.comusoapi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.comusoapi.service.IHistorialEstadoServicio;

@Controller
@RequestMapping("/historialestado")
public class HistorialEstadoControlador {

    @Autowired
    private IHistorialEstadoServicio servicioHistorial;

    @GetMapping("/listar")
    public String listarHistorial(Model model) {
        // TODO: Obtener historial y agregar al model
        // model.addAttribute("historial", servicioHistorial.listarTodos());
        return "historialestado/listarhistorial";
    }

    @GetMapping("/nuevo")
    public String nuevoHistorial(@RequestParam("idOrden") int idOrden, Model model) {
        model.addAttribute("idorden", idOrden);
        return "historialestado/nuevohistorial";
    }

    @PostMapping("/guardar")
    public String guardarHistorial(
            @RequestParam("idorden") int idOrden,
            @RequestParam("estadoanterior") String estadoAnterior,
            @RequestParam("estadonuevo") String estadoNuevo,
            @RequestParam("observacion") String observacion,
            @RequestParam("modificadopor") String modificadoPor,
            Model model) {
        
        // TODO: Llamar al servicio para guardar
        // servicioHistorial.guardar(...);
        
        model.addAttribute("mensaje", "Estado actualizado exitosamente");
        return "redirect:/historialestado/listar?idOrden=" + idOrden;
    }

    @GetMapping("/ver")
    public String verHistorial(@RequestParam("id") int id, Model model) {
        // TODO: Obtener historial por ID y agregar al model
        // model.addAttribute("historial", servicioHistorial.buscarPorId(id));
        return "historialestado/verhistorial";
    }
}
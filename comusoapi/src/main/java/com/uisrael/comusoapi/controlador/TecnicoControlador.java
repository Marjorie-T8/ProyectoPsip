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
import com.uisrael.comusoapi.service.ISolicitudServicioServicio; 

@Controller
@RequestMapping("/tecnico")
public class TecnicoControlador {

    @Autowired
    private ITecnicoServicio servicioTecnico;

    @Autowired
    private ISolicitudServicioServicio servicioSolicitud; // <--- 2. ESTO SOLUCIONA EL "CANNOT BE RESOLVED"

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
        // CERO lógica aquí, solo llamamos al servicio
        servicioTecnico.crearTecnico(dto);
        return "redirect:/tecnico/listar";
    }

    @GetMapping("/solicitud")
    public String listarSolicitud(Model model) {
        // Quitamos la declaración de 'List' para evitar errores de tipos
        // El model recibe directamente lo que el servicio entrega
        model.addAttribute("nombrePagina", "PANEL DE SOLICITUDES PENDIENTES");
        model.addAttribute("solicitudes", servicioTecnico.listarSolicitudesPendientes());
        model.addAttribute("rolUsuario", "TECNICO"); 
        
        return "tecnico/panel-solicitudes"; 
    }
} // <--- 3. LLAVE DE CIERRE CORRECTA (Elimina el Syntax Error)

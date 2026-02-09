package com.uisrael.comusoapi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.comusoapi.service.IMensajeClienteServicio;

@Controller
@RequestMapping("/mensajeciente")
public class MensajeClienteControlador {

    @Autowired
    private IMensajeClienteServicio servicioMensaje;

    @GetMapping("/listar")
    public String listarMensajes(Model model) {
        // TODO: Obtener lista de mensajes y agregar al model
        // model.addAttribute("mensajes", servicioMensaje.listarTodos());
        return "mensajecliente/listarmensajes";
    }

    @GetMapping("/nuevo")
    public String nuevoMensaje(@RequestParam("idOrden") int idOrden, Model model) {
        model.addAttribute("idorden", idOrden);
        return "mensajecliente/nuevomensaje";
    }

    @PostMapping("/enviar")
    public String enviarMensaje(
            @RequestParam("idorden") int idOrden,
            @RequestParam("tipomensaje") String tipoMensaje,
            @RequestParam("medio") String medio,
            @RequestParam("destinatario") String destinatario,
            @RequestParam("contenido") String contenido,
            @RequestParam("estadoenvio") String estadoEnvio,
            Model model) {
        
        // TODO: Llamar al servicio para enviar
        // servicioMensaje.enviar(...);
        
        model.addAttribute("mensaje", "Mensaje enviado exitosamente");
        return "redirect:/mensajeciente/listar?idOrden=" + idOrden;
    }

    @GetMapping("/ver")
    public String verMensaje(@RequestParam("id") int id, Model model) {
        // TODO: Obtener mensaje por ID y agregar al model
        // model.addAttribute("mensaje", servicioMensaje.buscarPorId(id));
        return "mensajecliente/vermensaje";
    }
}
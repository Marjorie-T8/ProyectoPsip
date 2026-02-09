package com.uisrael.comusoapi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.comusoapi.service.IFotoVerificacionServicio;

@Controller
@RequestMapping("/fotoverificacion")
public class FotoVerificacionControlador {

    @Autowired
    private IFotoVerificacionServicio servicioFoto;

    @GetMapping("/listar")
    public String listarFotos(Model model) {
        // TODO: Obtener lista de fotos y agregar al model
        // model.addAttribute("fotos", servicioFoto.listarTodos());
        return "fotoverificacion/listarfoto";
    }

    @GetMapping("/nueva")
    public String nuevaFoto(@RequestParam("idOrden") int idOrden, Model model) {
        model.addAttribute("idorden", idOrden);
        return "fotoverificacion/nuevafoto";
    }

    @PostMapping("/guardar")
    public String guardarFoto(
            @RequestParam("idorden") int idOrden,
            @RequestParam("rutaarchivo") String rutaArchivo,
            @RequestParam("descripcion") String descripcion,
            Model model) {
        
        // TODO: Llamar al servicio para guardar
        // servicioFoto.guardar(...);
        
        model.addAttribute("mensaje", "Foto guardada exitosamente");
        return "redirect:/fotoverificacion/listar?idOrden=" + idOrden;
    }

    @GetMapping("/ver")
    public String verFoto(@RequestParam("id") int id, Model model) {
        // TODO: Obtener foto por ID y agregar al model
        // model.addAttribute("foto", servicioFoto.buscarPorId(id));
        return "fotoverificacion/verfoto";
    }
}
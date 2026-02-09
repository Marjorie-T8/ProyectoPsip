package com.uisrael.comusoapi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.comusoapi.service.IAnexoDocumentosServicio;

@Controller
@RequestMapping("/anexodocumentos")
public class AnexoDocumentosControlador {

    @Autowired
    private IAnexoDocumentosServicio servicioAnexo;

    @GetMapping("/listar")
    public String listarAnexos(Model model) {
        // TODO: Obtener lista de anexos y agregar al model
        // model.addAttribute("anexos", servicioAnexo.listarTodos());
        return "anexodocumento/listaranexo";
    }

    @GetMapping("/nuevo")
    public String nuevoAnexo(@RequestParam("idOrden") int idOrden, Model model) {
        model.addAttribute("idorden", idOrden);
        return "anexodocumento/nuevoanexo";
    }

    @PostMapping("/guardar")
    public String guardarAnexo(
            @RequestParam("idorden") int idOrden,
            @RequestParam("nombreoriginal") String nombreOriginal,
            @RequestParam("nombreguardado") String nombreGuardado,
            @RequestParam("tipomime") String tipoMime,
            Model model) {
        
        // TODO: Llamar al servicio para guardar
        // servicioAnexo.guardar(...);
        
        model.addAttribute("mensaje", "Anexo guardado exitosamente");
        return "redirect:/anexodocumento/listar?idOrden=" + idOrden;
    }

    @GetMapping("/ver")
    public String verAnexo(@RequestParam("id") int id, Model model) {
        // TODO: Obtener anexo por ID y agregar al model
        // model.addAttribute("anexo", servicioAnexo.buscarPorId(id));
        return "anexodocumento/veranexo";
    }
}
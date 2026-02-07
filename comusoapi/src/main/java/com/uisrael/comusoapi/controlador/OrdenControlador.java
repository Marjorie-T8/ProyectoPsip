package com.uisrael.comusoapi.controlador;



import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uisrael.comusoapi.modelo.dto.request.OrdenTrabajoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.OrdenTrabajoResponseDTO;
import com.uisrael.comusoapi.service.IClienteServicio;
import com.uisrael.comusoapi.service.IEquipoServicio;
import com.uisrael.comusoapi.service.IOrdenTrabajoServicio;
import com.uisrael.comusoapi.service.ITecnicoServicio;
import com.uisrael.comusoapi.service.ITipoServicioServicio;


@Controller
@RequestMapping("/orden")
public class OrdenControlador {

    @Autowired
    private IOrdenTrabajoServicio servicioOrden;

    @Autowired
    private IClienteServicio servicioCliente;

    @Autowired
    private ITecnicoServicio servicioTecnico;

    @Autowired
    private ITipoServicioServicio servicioTipo;

  
    @Autowired
    private IEquipoServicio servicioEquipo;

    @GetMapping("/nueva")
    public String mostrarFormularioNueva(@RequestParam(name = "idCliente", required = false) Integer idCliente, Model model) {
        OrdenTrabajoRequestDTO ordenDTO = new OrdenTrabajoRequestDTO();
        
        if (idCliente != null && idCliente > 0) {
            ordenDTO.setIdcliente(idCliente);
            ordenDTO.setEstado("PENDIENTE"); 
            ordenDTO.setFechacreacion(LocalDate.now()); 
            
            model.addAttribute("listaequipos", servicioEquipo.listarEquiposPorCliente(idCliente));
        }

        model.addAttribute("ordenDTO", ordenDTO);
        model.addAttribute("idClienteSeleccionado", idCliente);
        
        model.addAttribute("listaclientes", servicioCliente.listarCliente());
        model.addAttribute("listatecnicos", servicioTecnico.listarTecnico());
        model.addAttribute("listaservicios", servicioTipo.listarTipoServicio());

        return "orden/nuevaorden";
    }
    @PostMapping("/guardar")
    public String guardarOrden(@ModelAttribute("ordenDTO") OrdenTrabajoRequestDTO ordenDTO, RedirectAttributes flash) {
        try {
            servicioOrden.crearOrdenTrabajo(ordenDTO);
            flash.addFlashAttribute("mensaje", "Orden guardada con éxito");
            flash.addFlashAttribute("tipo", "success");
        } catch (Exception e) {
            flash.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
            flash.addFlashAttribute("tipo", "error");
        }
        return "redirect:/orden/listar";
    }
 
    @GetMapping("/listar")
    public String listar(Model model) {
    	model.addAttribute("listaordenes", servicioOrden.listarOrdenesTrabajo());
    	return "orden/listarorden"; 
    }
 
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id, RedirectAttributes flash) {
        try {
          
            servicioOrden.eliminarOrdenTrabajo(id); 
            flash.addFlashAttribute("mensaje", "Orden eliminada exitosamente");
        } catch (Exception e) {
            flash.addFlashAttribute("mensaje", "Error al eliminar: " + e.getMessage());
        }
        return "redirect:/orden/listar";
    }
 
    @GetMapping("/ver/{id}")
    public String ver(@PathVariable int id, Model model) {
        OrdenTrabajoResponseDTO ordenEncontrada = servicioOrden.buscarOrdenTrabajoPorId(id);
        
    
        model.addAttribute("orden", ordenEncontrada); 
        
        return "orden/verorden";
    }
    @GetMapping("/consultar")
    public String consultarToken(@RequestParam String token, @RequestParam(required = false) String rol, Model model) {
        model.addAttribute("rol", rol);
        OrdenTrabajoResponseDTO orden = servicioOrden.buscarPorToken(token);
        
        if (orden == null) {
            model.addAttribute("error", "No se encontró ninguna orden con el código ingresado.");
            return "solicitud/revisartoken"; // Regresa a la misma página con el error
        }
        
        model.addAttribute("orden", orden);
        return "orden/verorden"; // Si lo encuentra, lo manda directo al detalle
    }
}
   

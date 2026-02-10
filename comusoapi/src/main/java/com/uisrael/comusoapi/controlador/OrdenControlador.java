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

 // OrdenControlador.java (Proyecto Frontend)
    @GetMapping("/nueva")
    public String nuevaOrden(@RequestParam(name = "idCliente", required = false, defaultValue = "0") int idCliente, Model model) {
        
  
        model.addAttribute("listaclientes", servicioCliente.listarCliente());          
        model.addAttribute("listaservicios", servicioTipo.listarTipoServicio());        
        model.addAttribute("listatecnicos", servicioTecnico.listarTecnico());

        OrdenTrabajoRequestDTO ordenDTO = new OrdenTrabajoRequestDTO();
        ordenDTO.setEstado("PENDIENTE");
        ordenDTO.setFechaSolicitud(LocalDate.now());

        if (idCliente > 0) {
            // Buscamos la info del cliente para mostrar la Cédula/RUC
            var cliente = servicioCliente.buscarClientePorId(idCliente);
            model.addAttribute("clienteInfo", cliente); 
            
            // Cargamos los equipos filtrados por cliente
            model.addAttribute("listaequipos", servicioEquipo.listarEquiposPorCliente(idCliente));
            
            ordenDTO.setIdCliente(idCliente);
            model.addAttribute("idClienteSeleccionado", idCliente);
        }

        model.addAttribute("ordenDTO", ordenDTO);
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
    public String ver(@PathVariable int id, Model model, RedirectAttributes flash) {
        try {
            
            OrdenTrabajoResponseDTO ordenEncontrada = servicioOrden.buscarOrdenTrabajoPorId(id);
            
            if (ordenEncontrada == null) {
                flash.addFlashAttribute("mensaje", "La orden no existe");
                flash.addFlashAttribute("tipo", "error");
                return "redirect:/orden/listar";
            }

            model.addAttribute("orden", ordenEncontrada); 
            
            return "orden/verorden"; 
            
        } catch (Exception e) {
            flash.addFlashAttribute("mensaje", "Error al conectar con el servidor: " + e.getMessage());
            flash.addFlashAttribute("tipo", "error");
            return "redirect:/orden/listar";
        }
    }
}
   

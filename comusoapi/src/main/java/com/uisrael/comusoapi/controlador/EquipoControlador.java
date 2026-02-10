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
import com.uisrael.comusoapi.modelo.dto.response.ClienteResponseDTO;
import com.uisrael.comusoapi.modelo.dto.response.EquipoResponseDTO;
import com.uisrael.comusoapi.service.IClienteServicio;
import com.uisrael.comusoapi.service.IEquipoServicio;

@Controller
@RequestMapping("/equipo")
public class EquipoControlador {

    @Autowired
    private IEquipoServicio servicioEquipo;

    @Autowired
    private IClienteServicio servicioCliente; 

    @GetMapping("/listarPorCliente/{id}")
    public String listarPorCliente(@PathVariable int id, Model model) {
      
        model.addAttribute("listaequipos", servicioEquipo.listarEquiposPorCliente(id));
        
        ClienteResponseDTO cliente = servicioCliente.buscarClientePorId(id);
        model.addAttribute("nombreCliente", cliente.getNombre()); 
        
        model.addAttribute("idCliente", id);
        return "equipo/listarequipos"; 
    }

    @GetMapping("/nuevo")
    public String nuevoEquipo(@RequestParam(name = "idCliente") int idCliente, Model model) {
        EquipoRequestDTO equipoDTO = new EquipoRequestDTO();
        equipoDTO.setIdCliente(idCliente); 
        
        model.addAttribute("idCliente", idCliente);
        model.addAttribute("equipoDTO", equipoDTO);
        return "equipo/nuevoequipo"; 
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("equipoDTO") EquipoRequestDTO equipoDTO, Model model) {
        try {
            servicioEquipo.crearEquipo(equipoDTO);
            return "redirect:/equipo/listarPorCliente/" + equipoDTO.getIdCliente();

        } catch (org.springframework.web.reactive.function.client.WebClientResponseException.Conflict ex) {
            // Captura el error 409 del Backend
            model.addAttribute("equipoDTO", equipoDTO);
            model.addAttribute("idCliente", equipoDTO.getIdCliente());
            model.addAttribute("error", "EL EQUIPO EXISTE REVISAR"); 
            return "equipo/nuevoequipo"; 

        } catch (Exception ex) {
            model.addAttribute("equipoDTO", equipoDTO);
            model.addAttribute("idCliente", equipoDTO.getIdCliente());
            model.addAttribute("error", "Error técnico: " + ex.getMessage());
            return "equipo/nuevoequipo";
        }
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        EquipoResponseDTO equipo = servicioEquipo.buscarEquipoPorId(id);
         model.addAttribute("equipoDTO", equipo); 
        model.addAttribute("idCliente", equipo.getIdCliente());
        
        return "equipo/nuevoequipo"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        int idClie = servicioEquipo.buscarEquipoPorId(id).getIdCliente();
        
         servicioEquipo.eliminarEquipo(id);
        return "redirect:/equipo/listarPorCliente/" + idClie;
    }
}
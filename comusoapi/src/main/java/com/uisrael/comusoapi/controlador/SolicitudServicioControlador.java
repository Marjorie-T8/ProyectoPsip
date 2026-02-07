package com.uisrael.comusoapi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 1. IMPORTANTE: Imports de los DTOs y Servicios necesarios
import com.uisrael.comusoapi.modelo.dto.response.ClienteResponseDTO;
import com.uisrael.comusoapi.modelo.dto.response.EquipoResponseDTO;
import com.uisrael.comusoapi.service.ISolicitudServicioServicio;
import com.uisrael.comusoapi.service.IEquipoServicio;
import com.uisrael.comusoapi.service.IClienteServicio;

@Controller
@RequestMapping("/solicitud") 
public class SolicitudServicioControlador {

   
    @Autowired
    private ISolicitudServicioServicio servicioProcesador; 

    @Autowired
    private IEquipoServicio servicioEquipo; 

    @Autowired
    private IClienteServicio servicioCliente; 

    @GetMapping("/agendar")
    public String irAAgendar(@RequestParam("idEquipo") int idEquipo, Model model) {
        model.addAttribute("idequipo", idEquipo); // coincide con el hidden en el formulario
        return "solicitud/agendar"; // apunta a agendar.html
    }


    @PostMapping("/finalizar")
    public String guardarAgendamiento(
    	    @RequestParam("idequipo") int idequipo,
    	    @RequestParam("fechacita") String fechaCita,
    	    @RequestParam("horacita") String horaCita,
    	    @RequestParam("modalidadatencion") String modalidad,
    	    @RequestParam(value="descripcion", required=false) String descripcion,
    	    @RequestParam(value="direccionservicio", required=false) String direccion,
    	    Model model) {

    	    // AÑADIMOS 'direccion' y 'descripcion' a la llamada del servicio
    	    String ticket = servicioProcesador.agendar(idequipo, fechaCita, horaCita, modalidad, direccion, descripcion);

    	    EquipoResponseDTO equipo = servicioEquipo.buscarEquipoPorId(idequipo);
    	    ClienteResponseDTO cliente = servicioCliente.buscarClientePorId(equipo.getIdcliente());

    	    model.addAttribute("ticket", ticket);
    	    model.addAttribute("fecha", fechaCita + " " + horaCita);
    	    model.addAttribute("nombreCliente", cliente.getNombre());
    	    model.addAttribute("tipoEquipo", equipo.getTipo());
    	    model.addAttribute("marca", equipo.getMarca());
    	    model.addAttribute("estado", "PENDIENTE");

    	    return "Equipo/ticket";
    	}
}
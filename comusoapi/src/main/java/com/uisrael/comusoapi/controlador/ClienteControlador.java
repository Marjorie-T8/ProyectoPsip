package com.uisrael.comusoapi.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.comusoapi.modelo.dto.request.ClienteRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.ClienteResponseDTO;
import com.uisrael.comusoapi.service.IClienteServicio;


@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

    @Autowired
    private IClienteServicio servicioCliente;

    @GetMapping("/listar")
    public String listarcliente(Model model) {
        model.addAttribute("listacliente", servicioCliente.listarCliente());
        return "cliente/listarcliente";
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Model model) {
        ClienteRequestDTO nuevo = new ClienteRequestDTO();
        nuevo.setEstado(true); 
        model.addAttribute("cliente", nuevo);
        return "cliente/nuevocliente";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("cliente") ClienteRequestDTO cliente, Model model) {
        try {
            // Validamos si el ID es nulo antes de comparar. 
            // Si es null, asumimos que es un registro nuevo (0).
            Integer idActual = (cliente.getIdCliente() != null) ? cliente.getIdCliente() : 0;

            if (idActual > 0) {
                servicioCliente.actualizarCliente(idActual, cliente);
            } else {
                servicioCliente.crearCliente(cliente);
            }
            return "redirect:/cliente/listar";
            
        } catch (WebClientResponseException.Conflict ex) {
            model.addAttribute("cliente", cliente);
            // Aquí también usamos la validación segura para el mensaje
            boolean esEdicion = cliente.getIdCliente() != null && cliente.getIdCliente() > 0;
            String mensaje = esEdicion ? "LA CÉDULA YA PERTENECE A OTRO CLIENTE" : "EL CLIENTE YA EXISTE";
            
            model.addAttribute("error", mensaje);
            return "cliente/nuevocliente";
        } catch (Exception ex) {
            model.addAttribute("cliente", cliente);
            model.addAttribute("error", "Error: " + ex.getMessage());
            return "cliente/nuevocliente";
        }
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        
        servicioCliente.eliminarCliente(id);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable int id, Model model) {
        
        ClienteResponseDTO cliente = servicioCliente.buscarClientePorId(id); 
        
       
        System.out.println("Fecha recibida del backend: " + cliente.getFechaNacimiento());
        
        model.addAttribute("cliente", cliente);
        model.addAttribute("esEdicion", true);
        return "cliente/nuevocliente"; 
    }
    
}
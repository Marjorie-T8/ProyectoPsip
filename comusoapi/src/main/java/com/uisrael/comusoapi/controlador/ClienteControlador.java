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
        model.addAttribute("cliente", new ClienteRequestDTO());
        return "cliente/nuevocliente";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("cliente") ClienteRequestDTO cliente, Model model) {
        try {
            // El controlador sigue sin lógica, solo llama al servicio
            servicioCliente.crearCliente(cliente);
            return "redirect:/cliente/listar";
        } catch (WebClientResponseException.Conflict ex) {
            // ESTO ES PARA LA CÉDULA DUPLICADA
            model.addAttribute("cliente", cliente);
            model.addAttribute("error", "EL CLIENTE YA EXISTE REVISA LISTAR CLIENTE"); 
            return "cliente/nuevocliente"; 
        } catch (Exception ex) {
            // ESTO ATRAPA EL ERROR 400 QUE ESTÁS TENIENDO
            model.addAttribute("cliente", cliente);
            model.addAttribute("error", "Error técnico: " + ex.getMessage());
            return "cliente/nuevocliente";
        }
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        // Tu borrado lógico ocurre dentro de este método en el Backend
        servicioCliente.eliminarCliente(id);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable int id, Model model) {
        ClienteResponseDTO cliente = servicioCliente.buscarClientePorId(id); 
        
        // Importante: El formulario debe ser capaz de leer tanto RequestDTO como ResponseDTO
        model.addAttribute("cliente", cliente);
        model.addAttribute("esEdicion", true); // Útil para cambiar el título en el HTML
        return "cliente/nuevocliente"; 
    }
}
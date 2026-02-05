package com.uisrael.comusoapi.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String guardar(@ModelAttribute("cliente") ClienteRequestDTO cliente) {
        servicioCliente.crearCliente(cliente);
        return "redirect:/cliente/listar";
    }

   
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        servicioCliente.eliminarCliente(id);
        return "redirect:/cliente/listar";
    }
    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable int id, Model model) {
        
        ClienteResponseDTO cliente = servicioCliente.buscarClientePorId(id); 
        model.addAttribute("cliente", cliente);
        return "cliente/nuevocliente"; 
    }
}
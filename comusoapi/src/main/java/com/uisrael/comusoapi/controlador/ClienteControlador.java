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
import com.uisrael.comusoapi.modelo.dto.request.EquipoRequestDTO;
import com.uisrael.comusoapi.modelo.dto.response.ClienteResponseDTO;
import com.uisrael.comusoapi.service.IClienteServicio;

@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

    @Autowired
    private IClienteServicio servicioCliente;

    @GetMapping("/inicio")
    public String paginaPrincipal(Model model) {
        model.addAttribute("nombrePagina", "Servicios Técnicos");
        return "Inicio";
    }

    @GetMapping("/nuevo")
    public String irAFormulario(Model model) {
        model.addAttribute("cliente", new ClienteRequestDTO());
        model.addAttribute("equipo", new EquipoRequestDTO());
        return "cliente/nuevocliente";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("cliente") ClienteRequestDTO clienteDTO) {

        ClienteResponseDTO clienteGuardado =
                servicioCliente.crearCliente(clienteDTO);

        return "redirect:/equipo/nuevo/" + clienteGuardado.getIdcliente();
    }


    @GetMapping("/listar")
    public String listarcliente(Model model) {
        model.addAttribute("listacliente", servicioCliente.listarCliente());
        return "cliente/listarcliente";
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

package com.uisrael.comusoapi.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @GetMapping("/nuevo/{idCliente}")
    public String formularioEquipo(@PathVariable int idCliente, Model model) {
        EquipoRequestDTO dto = new EquipoRequestDTO();
        dto.setIdcliente(idCliente);
        model.addAttribute("equipoDTO", dto);
        return "equipo/nuevoequipo";
    }

    @PostMapping("/guardar")
    public String guardarEquipo(@ModelAttribute EquipoRequestDTO dto) {
        EquipoResponseDTO equipoCreado = servicioEquipo.crearEquipo(dto);
        
        // Aquí NO hay lógica: solo usamos lo que devuelve el servicio
        return "redirect:/solicitud/agendar?idEquipo=" + equipoCreado.getIdequipo();
    }


    @GetMapping("/imprimir/{id}")
    public String imprimir(@PathVariable int id, Model model) {
       
        model.addAttribute("equipo", servicioEquipo.buscarEquipoPorId(id));
        return "equipo/ticket"; 
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        int idClie = servicioEquipo.buscarEquipoPorId(id).getIdcliente();        
         servicioEquipo.eliminarEquipo(id);
        return "redirect:/equipo/listarPorCliente/" + idClie;
    }
}
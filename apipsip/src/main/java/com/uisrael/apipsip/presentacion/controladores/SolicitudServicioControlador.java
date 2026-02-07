package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uisrael.apipsip.aplicacion.casosuso.entradas.ISolicitudServicioUseCase;
import com.uisrael.apipsip.dominio.entidades.SolicitudServicio;
import com.uisrael.apipsip.presentacion.mapeadores.ISolicitudServicioDtoMapper;
import com.uisrael.apipsip.presentacion.dto.request.SolicitudServicioRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.SolicitudServicioResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/solicitud")
public class SolicitudServicioControlador {

    private final ISolicitudServicioUseCase useCase;
    private final ISolicitudServicioDtoMapper mapper;

    public SolicitudServicioControlador(ISolicitudServicioUseCase useCase, ISolicitudServicioDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<SolicitudServicioResponseDTO> listar() {
        return useCase.listarTodas().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    public SolicitudServicioResponseDTO crear(@Valid @RequestBody SolicitudServicioRequestDTO request) {
        try {
            SolicitudServicio domain = mapper.toDomain(request);
            SolicitudServicio creado = useCase.crear(domain);
            SolicitudServicioResponseDTO response = mapper.toResponseDto(creado);
            
            // Log temporal para ver qué pasa
            System.out.println("Solicitud creada con ID: " + response.getIdsolicitud());
            System.out.println("Ticket: " + response.getCodigoticket());
            
            return response;
        } catch (Exception e) {
            System.err.println("Error al crear solicitud:");
            System.err.println("Mensaje: " + e.getMessage());
            e.printStackTrace();
            throw e;  // o retorna ResponseEntity con error
        }
    }

    @GetMapping("/{id}")
    public SolicitudServicioResponseDTO buscarPorId(@PathVariable int id) {
        return mapper.toResponseDto(useCase.obtenerPorId(id));
    }

    @GetMapping("/ticket/{codigo}")
    public SolicitudServicioResponseDTO buscarPorTicket(@PathVariable String codigo) {
        return mapper.toResponseDto(useCase.obtenerPorCodigoTicket(codigo));
    }

    @GetMapping("/cliente/{idCliente}")
    public List<SolicitudServicioResponseDTO> listarPorCliente(@PathVariable int idCliente) {
        return useCase.listarPorCliente(idCliente).stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        useCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
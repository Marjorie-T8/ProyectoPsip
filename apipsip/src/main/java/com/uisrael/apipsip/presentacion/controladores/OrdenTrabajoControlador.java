package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IOrdenTrabajoUseCase;
import com.uisrael.apipsip.presentacion.mapeadores.IOrdenTrabajoDtoMapper;
import com.uisrael.apipsip.presentacion.dto.request.OrdenTrabajoRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.OrdenTrabajoResponseDTO;

@RestController
@RequestMapping("/api/orden-trabajo")
public class OrdenTrabajoControlador {

    private final IOrdenTrabajoUseCase ordenTrabajoUseCase;
    private final IOrdenTrabajoDtoMapper mapper;

    public OrdenTrabajoControlador(IOrdenTrabajoUseCase ordenTrabajoUseCase,
                                   IOrdenTrabajoDtoMapper mapper) {
        this.ordenTrabajoUseCase = ordenTrabajoUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<OrdenTrabajoResponseDTO> listar() {
        return ordenTrabajoUseCase.listar()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    public OrdenTrabajoResponseDTO crear(
            @Valid @RequestBody OrdenTrabajoRequestDTO request) {
        return mapper.toResponseDto(
                ordenTrabajoUseCase.crear(mapper.toDomain(request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        ordenTrabajoUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

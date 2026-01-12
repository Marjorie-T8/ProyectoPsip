package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.ITecnicoUseCase;
import com.uisrael.apipsip.presentacion.mapeadores.ITecnicoDtoMapper;
import com.uisrael.apipsip.presentacion.dto.request.TecnicoRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.TecnicoResponseDTO;

@RestController
@RequestMapping("/api/tecnico")
public class TecnicoControlador {

    private final ITecnicoUseCase tecnicoUseCase;
    private final ITecnicoDtoMapper mapper;

    public TecnicoControlador(ITecnicoUseCase tecnicoUseCase,
                              ITecnicoDtoMapper mapper) {
        this.tecnicoUseCase = tecnicoUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<TecnicoResponseDTO> listar() {
        return tecnicoUseCase.listar()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    public TecnicoResponseDTO crear(@Valid @RequestBody TecnicoRequestDTO request) {
        return mapper.toResponseDto(
                tecnicoUseCase.crear(mapper.toDomain(request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        tecnicoUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

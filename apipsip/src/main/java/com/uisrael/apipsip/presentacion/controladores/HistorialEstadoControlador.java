package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IHistorialEstadoUseCase;
import com.uisrael.apipsip.presentacion.mapeadores.IHistorialEstadoDtoMapper;
import com.uisrael.apipsip.presentacion.dto.request.HistorialEstadoRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.HistorialEstadoResponseDTO;

@RestController
@RequestMapping("/api/historialestado")
public class HistorialEstadoControlador {

    private final IHistorialEstadoUseCase historialEstadoUseCase;
    private final IHistorialEstadoDtoMapper mapper;

    public HistorialEstadoControlador(IHistorialEstadoUseCase historialEstadoUseCase,
                                      IHistorialEstadoDtoMapper mapper) {
        this.historialEstadoUseCase = historialEstadoUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<HistorialEstadoResponseDTO> listar() {
        return historialEstadoUseCase.listar()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    public HistorialEstadoResponseDTO crear(
            @Valid @RequestBody HistorialEstadoRequestDTO request) {
        return mapper.toResponseDto(
                historialEstadoUseCase.crear(mapper.toDomain(request))
        );
    }

    @GetMapping("/{id}")
    public HistorialEstadoResponseDTO obtenerPorId(@PathVariable int id) {
        return mapper.toResponseDto(historialEstadoUseCase.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public HistorialEstadoResponseDTO actualizar(@PathVariable int id,
            @Valid @RequestBody HistorialEstadoRequestDTO request) {
        return mapper.toResponseDto(
                historialEstadoUseCase.actualizar(id, mapper.toDomain(request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        historialEstadoUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/orden/{idOrden}")
    public List<HistorialEstadoResponseDTO> listarPorOrden(@PathVariable int idOrden) {
        return historialEstadoUseCase.listar().stream()
                .filter(historial -> historial.getIdOrden() == idOrden)
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/orden/{idOrden}/ultimo")
    public HistorialEstadoResponseDTO obtenerUltimoPorOrden(@PathVariable int idOrden) {
        return historialEstadoUseCase.listar().stream()
                .filter(historial -> historial.getIdOrden() == idOrden)
                .max((h1, h2) -> h1.getFechaCambio().compareTo(h2.getFechaCambio()))
                .map(mapper::toResponseDto)
                .orElse(null);
    }
}
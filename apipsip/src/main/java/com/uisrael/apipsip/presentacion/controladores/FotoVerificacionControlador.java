package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IFotoVerificacionUseCase;
import com.uisrael.apipsip.presentacion.mapeadores.IFotoVerificacionDtoMapper;
import com.uisrael.apipsip.presentacion.dto.request.FotoVerificacionRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.FotoVerificacionResponseDTO;

@RestController
@RequestMapping("/api/fotoverificacion")
public class FotoVerificacionControlador {

    private final IFotoVerificacionUseCase fotoVerificacionUseCase;
    private final IFotoVerificacionDtoMapper mapper;

    public FotoVerificacionControlador(IFotoVerificacionUseCase fotoVerificacionUseCase,
                                       IFotoVerificacionDtoMapper mapper) {
        this.fotoVerificacionUseCase = fotoVerificacionUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<FotoVerificacionResponseDTO> listar() {
        return fotoVerificacionUseCase.listar()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    public FotoVerificacionResponseDTO crear(
            @Valid @RequestBody FotoVerificacionRequestDTO request) {
        return mapper.toResponseDto(
                fotoVerificacionUseCase.crear(mapper.toDomain(request))
        );
    }

    @GetMapping("/{id}")
    public FotoVerificacionResponseDTO obtenerPorId(@PathVariable int id) {
        return mapper.toResponseDto(fotoVerificacionUseCase.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public FotoVerificacionResponseDTO actualizar(@PathVariable int id,
            @Valid @RequestBody FotoVerificacionRequestDTO request) {
        return mapper.toResponseDto(
                fotoVerificacionUseCase.actualizar(id, mapper.toDomain(request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        fotoVerificacionUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/orden/{idOrden}")
    public List<FotoVerificacionResponseDTO> listarPorOrden(@PathVariable int idOrden) {
        return fotoVerificacionUseCase.listar().stream()
                .filter(foto -> foto.getIdOrden() == idOrden)
                .map(mapper::toResponseDto)
                .toList();
    }
}
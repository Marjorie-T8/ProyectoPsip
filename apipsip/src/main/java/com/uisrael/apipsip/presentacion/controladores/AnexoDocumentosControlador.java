package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IAnexoDocumentosUseCase;
import com.uisrael.apipsip.presentacion.mapeadores.IAnexoDocumentosDtoMapper;
import com.uisrael.apipsip.presentacion.dto.request.AnexoDocumentosRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.AnexoDocumentosResponseDTO;

@RestController
@RequestMapping("/api/anexodocumentos")
public class AnexoDocumentosControlador {

    private final IAnexoDocumentosUseCase anexoDocumentosUseCase;
    private final IAnexoDocumentosDtoMapper mapper;

    public AnexoDocumentosControlador(IAnexoDocumentosUseCase anexoDocumentosUseCase,
                                      IAnexoDocumentosDtoMapper mapper) {
        this.anexoDocumentosUseCase = anexoDocumentosUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<AnexoDocumentosResponseDTO> listar() {
        return anexoDocumentosUseCase.listar()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    public AnexoDocumentosResponseDTO crear(
            @Valid @RequestBody AnexoDocumentosRequestDTO request) {
        return mapper.toResponseDto(
                anexoDocumentosUseCase.crear(mapper.toDomain(request))
        );
    }

    @GetMapping("/{id}")
    public AnexoDocumentosResponseDTO obtenerPorId(@PathVariable int id) {
        return mapper.toResponseDto(anexoDocumentosUseCase.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public AnexoDocumentosResponseDTO actualizar(@PathVariable int id,
            @Valid @RequestBody AnexoDocumentosRequestDTO request) {
        return mapper.toResponseDto(
                anexoDocumentosUseCase.actualizar(id, mapper.toDomain(request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        anexoDocumentosUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
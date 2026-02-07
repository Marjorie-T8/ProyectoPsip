package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IPaginaWebUseCase;
import com.uisrael.apipsip.presentacion.mapeadores.IPaginaWebDtoMapper;
import com.uisrael.apipsip.presentacion.dto.request.PaginaWebRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.PaginaWebResponseDTO;

@RestController
@RequestMapping("/api/paginaweb")
public class PaginaWebControlador {

    private final IPaginaWebUseCase paginaWebUseCase;
    private final IPaginaWebDtoMapper mapper;

    public PaginaWebControlador(IPaginaWebUseCase paginaWebUseCase,
                                IPaginaWebDtoMapper mapper) {
        this.paginaWebUseCase = paginaWebUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PaginaWebResponseDTO> listar() {
        return paginaWebUseCase.listar()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    public PaginaWebResponseDTO crear(
            @Valid @RequestBody PaginaWebRequestDTO request) {
        return mapper.toResponseDto(
                paginaWebUseCase.crear(mapper.toDomain(request))
        );
    }

    @GetMapping("/{id}")
    public PaginaWebResponseDTO obtenerPorId(@PathVariable int id) {
        return mapper.toResponseDto(paginaWebUseCase.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public PaginaWebResponseDTO actualizar(@PathVariable int id,
            @Valid @RequestBody PaginaWebRequestDTO request) {
        return mapper.toResponseDto(
                paginaWebUseCase.actualizar(id, mapper.toDomain(request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        paginaWebUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/orden/{idOrden}")
    public List<PaginaWebResponseDTO> listarPorOrden(@PathVariable int idOrden) {
        return paginaWebUseCase.listar().stream()
                .filter(pagina -> pagina.getIdOrden() == idOrden)
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/tipo/{tipoAcceso}")
    public List<PaginaWebResponseDTO> listarPorTipoAcceso(@PathVariable String tipoAcceso) {
        return paginaWebUseCase.listar().stream()
                .filter(pagina -> pagina.getTipoAcceso().equalsIgnoreCase(tipoAcceso))
                .map(mapper::toResponseDto)
                .toList();
    }
}
package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uisrael.apipsip.aplicacion.casosuso.entradas.IInformeFinalUseCase;
import com.uisrael.apipsip.presentacion.mapeadores.IInformeFinalDtoMapper;
import com.uisrael.apipsip.presentacion.dto.request.InformeFinalRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.InformeFinalResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/informefinal")
public class InformeFinalControlador {

    private final IInformeFinalUseCase useCase;
    private final IInformeFinalDtoMapper mapper;

    public InformeFinalControlador(IInformeFinalUseCase useCase, IInformeFinalDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<InformeFinalResponseDTO> listar() {
        return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
    }

    @PostMapping
    public InformeFinalResponseDTO crear(@Valid @RequestBody InformeFinalRequestDTO request) {
        return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
    }

    @GetMapping("/{id}")
    public InformeFinalResponseDTO buscarPorId(@PathVariable int id) {
        return mapper.toResponseDto(useCase.obtenerPorId(id));
    }

    @GetMapping("/orden/{idOrden}")
    public InformeFinalResponseDTO buscarPorIdOrden(@PathVariable int idOrden) {
        return mapper.toResponseDto(useCase.obtenerPorIdOrden(idOrden));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        useCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
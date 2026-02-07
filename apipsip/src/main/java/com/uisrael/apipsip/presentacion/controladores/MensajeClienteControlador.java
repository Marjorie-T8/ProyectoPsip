package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IMensajeClienteUseCase;
import com.uisrael.apipsip.presentacion.mapeadores.IMensajeClienteDtoMapper;
import com.uisrael.apipsip.presentacion.dto.request.MensajeClienteRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.MensajeClienteResponseDTO;

@RestController
@RequestMapping("/api/mensajeciente")
public class MensajeClienteControlador {

    private final IMensajeClienteUseCase mensajeClienteUseCase;
    private final IMensajeClienteDtoMapper mapper;

    public MensajeClienteControlador(IMensajeClienteUseCase mensajeClienteUseCase,
                                     IMensajeClienteDtoMapper mapper) {
        this.mensajeClienteUseCase = mensajeClienteUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<MensajeClienteResponseDTO> listar() {
        return mensajeClienteUseCase.listar()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    public MensajeClienteResponseDTO crear(
            @Valid @RequestBody MensajeClienteRequestDTO request) {
        return mapper.toResponseDto(
                mensajeClienteUseCase.crear(mapper.toDomain(request))
        );
    }

    @GetMapping("/{id}")
    public MensajeClienteResponseDTO obtenerPorId(@PathVariable int id) {
        return mapper.toResponseDto(mensajeClienteUseCase.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public MensajeClienteResponseDTO actualizar(@PathVariable int id,
            @Valid @RequestBody MensajeClienteRequestDTO request) {
        return mapper.toResponseDto(
                mensajeClienteUseCase.actualizar(id, mapper.toDomain(request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        mensajeClienteUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/orden/{idOrden}")
    public List<MensajeClienteResponseDTO> listarPorOrden(@PathVariable int idOrden) {
        return mensajeClienteUseCase.listar().stream()
                .filter(mensaje -> mensaje.getIdOrden() == idOrden)
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/orden/{idOrden}/no-leidos")
    public List<MensajeClienteResponseDTO> listarNoLeidosPorOrden(@PathVariable int idOrden) {
        return mensajeClienteUseCase.listar().stream()
                .filter(mensaje -> mensaje.getIdOrden() == idOrden && 
                                   !mensaje.getEstadoEnvio().equalsIgnoreCase("leido"))
                .map(mapper::toResponseDto)
                .toList();
    }
}
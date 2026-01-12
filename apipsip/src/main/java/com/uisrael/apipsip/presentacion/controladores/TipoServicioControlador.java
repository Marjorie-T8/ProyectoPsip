package com.uisrael.apipsip.presentacion.controladores;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.ITipoServicioUseCase;
import com.uisrael.apipsip.presentacion.mapeadores.ITipoServicioDtoMapper;
import com.uisrael.apipsip.presentacion.dto.request.TipoServicioRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.TipoServicioResponseDTO;

@RestController
@RequestMapping("/api/tipo-servicio")
public class TipoServicioControlador {

    private final ITipoServicioUseCase tipoServicioUseCase;
    private final ITipoServicioDtoMapper mapper;

    public TipoServicioControlador(ITipoServicioUseCase tipoServicioUseCase,
                                   ITipoServicioDtoMapper mapper) {
        this.tipoServicioUseCase = tipoServicioUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public List<TipoServicioResponseDTO> listar() {
        return tipoServicioUseCase.listar()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    public TipoServicioResponseDTO crear(
            @Valid @RequestBody TipoServicioRequestDTO request) {
        return mapper.toResponseDto(
                tipoServicioUseCase.crear(mapper.toDomain(request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        tipoServicioUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

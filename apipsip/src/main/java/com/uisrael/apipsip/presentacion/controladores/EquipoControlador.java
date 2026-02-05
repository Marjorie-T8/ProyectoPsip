package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IEquipoUseCase;
import com.uisrael.apipsip.presentacion.dto.request.EquipoRequestDTO;
import com.uisrael.apipsip.presentacion.dto.response.EquipoResponseDTO;
import com.uisrael.apipsip.presentacion.mapeadores.IEquipoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/equipo")
public class EquipoControlador {

    private final IEquipoUseCase equipoUseCase;
    private final IEquipoDtoMapper mapper;

    public EquipoControlador(IEquipoUseCase equipoUseCase, IEquipoDtoMapper mapper) {
        this.equipoUseCase = equipoUseCase;
        this.mapper = mapper;
    }


    @GetMapping
    public List<EquipoResponseDTO> listar(@RequestParam(required = false) String idCliente) {
        
        if (idCliente != null && idCliente.contains("eq.")) {
            int id = Integer.parseInt(idCliente.replace("eq.", ""));
            
            
            return equipoUseCase.listarPorCliente(id) 
                    .stream()
                    .map(mapper::toResponseDto)
                    .toList();
        }
        
       
        return equipoUseCase.listar()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }
    @PostMapping
    public EquipoResponseDTO crear(@Valid @RequestBody EquipoRequestDTO request) {
        return mapper.toResponseDto(
                equipoUseCase.crear(mapper.toDomain(request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        equipoUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

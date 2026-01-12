package com.uisrael.apipsip.presentacion.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.apipsip.aplicacion.casosuso.entradas.IClienteUseCase;
import com.uisrael.apipsip.presentacion.mapeadores.IClienteDtoMapper;
import jakarta.validation.Valid;
import com.uisrael.apipsip.presentacion.dto.response.ClienteResponseDTO;
import com.uisrael.apipsip.presentacion.dto.request.ClienteRequestDTO;
@RestController
@RequestMapping("/api/cliente")
public class ClienteControlador {
	private final IClienteUseCase clienteUseCase;
	private final IClienteDtoMapper mapper;
	public ClienteControlador(IClienteUseCase clienteUseCase, IClienteDtoMapper mapper) {
		
		this.clienteUseCase = clienteUseCase;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<ClienteResponseDTO> listar() {
		return clienteUseCase.listar().stream().map(mapper::toResponseDto).toList();
		}
	
	@PostMapping
	@ResponseStatus
	public ClienteResponseDTO crear(@Valid @RequestBody ClienteRequestDTO request){
		return mapper.toResponseDto(clienteUseCase.crear(mapper.toDomain(request)));
	
	}
	 @DeleteMapping ("{id}")
	 public ResponseEntity<Void>  eliminar(@PathVariable int id) {
		 clienteUseCase.eliminar(id);
		 return ResponseEntity.noContent().build();
	 }



}
	

	

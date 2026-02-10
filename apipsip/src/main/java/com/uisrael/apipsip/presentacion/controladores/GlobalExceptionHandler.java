package com.uisrael.apipsip.presentacion.controladores;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.uisrael.apipsip.aplicacion.excepciones.EntidadNoEncontradaException;
import com.uisrael.apipsip.aplicacion.excepciones.RecursoDuplicadoException;
@ControllerAdvice
public class GlobalExceptionHandler {


	    @ExceptionHandler(RecursoDuplicadoException.class)
	    public ResponseEntity<Object> manejarRecursoDuplicado(RecursoDuplicadoException ex) {
	     
	        Map<String, Object> respuesta = new LinkedHashMap<>();
	        respuesta.put("timestamp", LocalDateTime.now());
	        respuesta.put("estado", HttpStatus.CONFLICT.value()); 
	        respuesta.put("error", "Conflicto de Datos");
	        respuesta.put("mensaje", ex.getMessage());

	        return new ResponseEntity<>(respuesta, HttpStatus.CONFLICT);
	    }
	    @ExceptionHandler(EntidadNoEncontradaException.class) // <--- AGREGA ESTO
	    public ResponseEntity<Object> manejarNoEncontrado(EntidadNoEncontradaException ex) {
	        Map<String, Object> respuesta = new LinkedHashMap<>();
	        respuesta.put("timestamp", LocalDateTime.now());
	        respuesta.put("estado", HttpStatus.NOT_FOUND.value()); 
	        respuesta.put("mensaje", ex.getMessage());
	        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
	    }
}

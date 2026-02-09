package com.uisrael.apipsip.aplicacion.excepciones;



public class EquipoDuplicadoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public EquipoDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
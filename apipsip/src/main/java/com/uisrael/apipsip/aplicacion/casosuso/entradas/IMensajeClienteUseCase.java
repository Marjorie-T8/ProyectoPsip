package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import com.uisrael.apipsip.dominio.entidades.MensajeCliente;
import java.util.List;

public interface IMensajeClienteUseCase {

    MensajeCliente crear(MensajeCliente mensajeCliente);
    MensajeCliente obtenerPorId(int id);
    List<MensajeCliente> listar();
    void eliminar(int id);
    MensajeCliente actualizar(int id, MensajeCliente mensaje);
}
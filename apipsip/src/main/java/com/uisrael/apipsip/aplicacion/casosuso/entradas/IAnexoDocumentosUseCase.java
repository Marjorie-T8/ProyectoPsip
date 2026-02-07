package com.uisrael.apipsip.aplicacion.casosuso.entradas;

import com.uisrael.apipsip.dominio.entidades.AnexoDocumentos;
import java.util.List;

public interface IAnexoDocumentosUseCase {

    AnexoDocumentos crear(AnexoDocumentos anexoDocumentos);
    AnexoDocumentos obtenerPorId(int id);
    List<AnexoDocumentos> listar();
    void eliminar(int id);
    AnexoDocumentos actualizar(int id, AnexoDocumentos anexo);
}
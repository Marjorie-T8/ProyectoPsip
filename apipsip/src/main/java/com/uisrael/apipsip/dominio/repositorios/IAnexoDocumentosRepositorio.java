package com.uisrael.apipsip.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.apipsip.dominio.entidades.AnexoDocumentos;

public interface IAnexoDocumentosRepositorio {
	AnexoDocumentos guardar(AnexoDocumentos anexoDocumentos);
	Optional<AnexoDocumentos> buscarPorId(int id);
	List<AnexoDocumentos> listarTodos();
	void eliminar(int id);
}
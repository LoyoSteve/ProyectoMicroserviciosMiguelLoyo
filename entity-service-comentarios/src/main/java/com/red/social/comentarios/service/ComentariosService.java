package com.red.social.comentarios.service;

import java.util.List;

import com.red.social.comentarios.entity.Comentario;
import com.red.social.comentarios.modelo.ComentariosDto;

public interface ComentariosService {

	Comentario obtenerById(String id);

	Comentario guardar(ComentariosDto comentarioDto);

	Comentario modificar(String id, ComentariosDto comentarioDto);

	List<Comentario> obtenerTodo();
	
	void remover(String id);
}

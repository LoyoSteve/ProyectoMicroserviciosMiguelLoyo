package com.red.social.publicaciones.service;

import java.util.List;

import com.red.social.publicaciones.entity.Publicacion;
import com.red.social.publicaciones.modelo.PublicacionDto;

public interface PublicacionesService {

	Publicacion obtenerById(String id);

	Publicacion guardar(PublicacionDto publicacionDto);

	Publicacion modificar(String id, PublicacionDto publicacionDto);

	List<Publicacion> obtenerTodo();
	
	void remover(String id);
}

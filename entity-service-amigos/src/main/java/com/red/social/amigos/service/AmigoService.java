package com.red.social.amigos.service;

import java.util.List;

import com.red.social.amigos.entity.Amigo;
import com.red.social.amigos.modelo.AmigosDto;

public interface AmigoService {

	Amigo obtenerById(String id);

	Amigo guardar(AmigosDto usuarioDto);

	Amigo modificar(String id, AmigosDto usuarioDto);
	
	void remover(String id);
}

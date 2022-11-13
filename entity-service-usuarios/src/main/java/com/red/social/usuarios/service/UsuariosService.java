package com.red.social.usuarios.service;

import java.util.List;

import com.red.social.usuarios.entity.Usuario;
import com.red.social.usuarios.modelo.UsuariosDto;

public interface UsuariosService {

	Usuario obtenerById(String id);

	Usuario guardar(UsuariosDto usuarioDto);

	Usuario modificar(String id, UsuariosDto usuarioDto);

	List<Usuario> obtenerTodo();
	
	void remover(String id);
}

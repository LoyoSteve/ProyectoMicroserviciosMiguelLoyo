package com.red.social.usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.red.social.usuarios.entity.Usuario;
import com.red.social.usuarios.modelo.UsuariosDto;
import com.red.social.usuarios.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService{
	
	private UsuariosRepository usuariosRepository;
	
	public UsuariosServiceImpl(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}
	
	@Override
	public Usuario obtenerById(String id) {
		return usuariosRepository.findById(id)
				.orElseThrow(() -> UsuarioNoEncontradoException.from("No se encontro el cliente", id));
	}

	@Override
	public Usuario guardar(UsuariosDto usuarioDto) {
		Usuario usuario = Usuario.from(usuarioDto);
		return usuariosRepository.save(usuario);
	}

	@Override
	public Usuario modificar(String id, UsuariosDto usuariosDto) {
		Usuario usuarios = usuariosRepository.findById(id)
				.orElseThrow(() -> UsuarioNoEncontradoException.from("No se encontro el usuario", id));

		usuarios = usuarios.from(usuariosDto);

		usuarios = usuariosRepository.save(usuarios);

		return usuarios;
	}

	@Override
	public List<Usuario> obtenerTodo() {

		return usuariosRepository.findAll();
	}

	@Override
	public void remover(String id) {
		usuariosRepository.findById(id)
				.orElseThrow(() -> UsuarioNoEncontradoException.from("No se encontro el cliente", id));

		usuariosRepository.delete(id);
	}
}

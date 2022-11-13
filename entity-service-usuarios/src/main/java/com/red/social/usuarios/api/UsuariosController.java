package com.red.social.usuarios.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.red.social.usuarios.entity.Usuario;
import com.red.social.usuarios.modelo.Response;
import com.red.social.usuarios.modelo.UsuariosDto;
import com.red.social.usuarios.service.UsuariosServiceImpl;

@RestController
@RequestMapping("usuarios/v1")
public class UsuariosController {

	private static final Logger log = Logger.getLogger(UsuariosController.class);
	@Autowired
	private UsuariosServiceImpl usuariosServiceImpl;

	@PostMapping
	@ResponseStatus(CREATED)
	public Response crear(@RequestBody UsuariosDto usuarioDto) {
		log.info(">>> usuarios/v1 crear usuario");

		Usuario usuario = usuariosServiceImpl.guardar(usuarioDto);

		Response response = new Response("El usuario se ha creado exitosamente", "201", usuario);

		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Usuario consultarUsuarioById(@PathVariable("id") String id) {
		log.info(">>> usuarios/v1 buscando usuario con id: "+id);

		return usuariosServiceImpl.obtenerById(id);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<Usuario> obtenerTodosLosUsuarios() {
		log.info(">>> usuarios/v1 obtenertodos los usuarios ");

		return usuariosServiceImpl.obtenerTodo();
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public Response modificarUsuarios(@PathVariable("id") String id, @RequestBody UsuariosDto usuarioDto) {
		log.info(">>> usuarios/v1 modificarUsuarios");

		Usuario usuario = usuariosServiceImpl.modificar(id, usuarioDto);
		Response response = new Response("El usuario se ha actualizado exitosamente", "200", usuario);

		return response;

	}
}

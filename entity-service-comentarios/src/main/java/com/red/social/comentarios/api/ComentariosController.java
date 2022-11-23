package com.red.social.comentarios.api;

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

import com.red.social.comentarios.entity.Comentario;
import com.red.social.comentarios.modelo.Response;
import com.red.social.comentarios.modelo.ComentariosDto;
import com.red.social.comentarios.service.ComentariosServiceImpl;

@RestController
@RequestMapping("comentarios/v1")
public class ComentariosController {

	private static final Logger log = Logger.getLogger(ComentariosController.class);
	@Autowired
	private ComentariosServiceImpl comentariosServiceImpl;

	@PostMapping
	@ResponseStatus(CREATED)
	public Response crear(@RequestBody ComentariosDto comentarioDto) {
		log.info(">>> comentario/v1 crear comentario");

		Comentario comentario = comentariosServiceImpl.guardar(comentarioDto);

		Response response = new Response("El comentario se ha creado exitosamente", "201", comentario);

		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Comentario consultarComentarioById(@PathVariable("id") String id) {
		log.info(">>> comentario/v1 buscando comentario con id: "+id);

		return comentariosServiceImpl.obtenerById(id);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<Comentario> obtenerTodosLosComentarios() {
		log.info(">>> comentarios /v1 obtenertodos los comentarios");

		return comentariosServiceImpl.obtenerTodo();
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public Response modificarComentarios(@PathVariable("id") String id, @RequestBody ComentariosDto comentarioDto) {
		log.info(">>> comentarios/v1 modificar comentario");

		Comentario comentario = comentariosServiceImpl.modificar(id, comentarioDto);
		Response response = new Response("El comentario se ha actualizado exitosamente", "200", comentario);

		return response;

	}
}

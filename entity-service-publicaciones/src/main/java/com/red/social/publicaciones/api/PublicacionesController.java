package com.red.social.publicaciones.api;

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

import com.red.social.publicaciones.entity.Publicacion;
import com.red.social.publicaciones.modelo.Response;
import com.red.social.publicaciones.modelo.PublicacionDto;
import com.red.social.publicaciones.service.PublicacionesServiceImpl;

@RestController
@RequestMapping("publicaciones/v1")
public class PublicacionesController {

	private static final Logger log = Logger.getLogger(PublicacionesController.class);
	@Autowired
	private PublicacionesServiceImpl publicacionesServiceImpl;

	@PostMapping
	@ResponseStatus(CREATED)
	public Response crear(@RequestBody PublicacionDto publicacionDto) {
		log.info(">>> publicacion/v1 crear publicacion");

		Publicacion publicacion = publicacionesServiceImpl.guardar(publicacionDto);

		Response response = new Response("La publicacion se ha creado exitosamente", "201", publicacion);

		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Publicacion consultarPublicacionById(@PathVariable("id") String id) {
		log.info(">>> publicacion/v1 buscando publicacion con id: "+id);

		return publicacionesServiceImpl.obtenerById(id);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<Publicacion> obtenerTodasLasPublicaciones() {
		log.info(">>> publicacion/v1 obtenertodos las publicaciones ");

		return publicacionesServiceImpl.obtenerTodo();
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public Response modificarPublicacion(@PathVariable("id") String id, @RequestBody PublicacionDto publicacion) {
		log.info(">>> publicacion/v1 modificar publicacion");

		Publicacion pub = publicacionesServiceImpl.modificar(id, publicacion);
		Response response = new Response("La publicacion se ha actualizado exitosamente", "200", pub);

		return response;

	}
}

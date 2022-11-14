package com.red.social.amigos.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.red.social.amigos.entity.Amigo;
import com.red.social.amigos.modelo.Response;
import com.red.social.amigos.modelo.AmigosDto;
import com.red.social.amigos.service.AmigosServiceImpl;

@RestController
@RequestMapping("amigos/v1")
public class AmigosController {

	private static final Logger log = Logger.getLogger(AmigosController.class);
	@Autowired
	private AmigosServiceImpl amigosServiceImpl;

	@PostMapping
	@ResponseStatus(CREATED)
	public Response crear(@RequestBody AmigosDto amigoDto) {
		log.info(">>> amistad/v1 crear amistad");

		Amigo amigo = amigosServiceImpl.guardar(amigoDto);

		Response response = new Response("La amistad se ha creado exitosamente", "201", amigo);

		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Amigo consultarAmistadById(@PathVariable("id") String id) {
		log.info(">>> amigos/v1 buscando amistad con id: "+id);

		return amigosServiceImpl.obtenerById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public Response modificarAmistad(@PathVariable("id") String id, @RequestBody AmigosDto amistadDto) {
		log.info(">>> amistad/v1 modificarAmistad");

		Amigo usuario = amigosServiceImpl.modificar(id, amistadDto);
		Response response = new Response("La amistad se ha actualizado exitosamente", "200", usuario);

		return response;

	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public Response removerAmistad(@PathVariable("id") String idAmistad) {
		log.info(">>> amistad/v1 Borrar amistad");

		amigosServiceImpl.remover(idAmistad);
		Response response = new Response("La amistad se ha borrado exitosamente", "200", null);

		return response;

	}
}

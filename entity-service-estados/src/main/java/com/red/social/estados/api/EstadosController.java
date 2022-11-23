package com.red.social.estados.api;

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

import com.red.social.estados.entity.Estado;
import com.red.social.estados.modelo.EstadoDto;
import com.red.social.estados.modelo.Response;
import com.red.social.estados.service.EstadoServiceImpl;

@RestController
@RequestMapping("estados/v1")
public class EstadosController {

	private static final Logger log = Logger.getLogger(EstadosController.class);
	@Autowired
	private EstadoServiceImpl estadosServiceImpl;

	@PostMapping
	@ResponseStatus(CREATED)
	public Response crear(@RequestBody EstadoDto estadoDto) {
		log.info(">>> estado/v1 crear estado");

		Estado estado = estadosServiceImpl.guardar(estadoDto);

		Response response = new Response("El estado se ha creado exitosamente", "201", estado);

		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Estado consultarEstadoById(@PathVariable("id") String id) {
		log.info(">>> estado/v1 buscando estado con id: "+id);

		return estadosServiceImpl.obtenerById(id);
	}

	@GetMapping
	@ResponseStatus(OK)
	public List<Estado> obtenerTodasLosEstados() {
		log.info(">>> estados/v1 obtener todos los estados ");

		return estadosServiceImpl.obtenerTodo();
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public Response modificarEstados(@PathVariable("id") String id, @RequestBody EstadoDto estado) {
		log.info(">>> estados/v1 modificar estado");

		Estado pub = estadosServiceImpl.modificar(id, estado);
		Response response = new Response("El estado se ha actualizado exitosamente", "200", pub);

		return response;

	}
}

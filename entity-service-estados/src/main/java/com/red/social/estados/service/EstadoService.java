package com.red.social.estados.service;

import java.util.List;

import com.red.social.estados.entity.Estado;
import com.red.social.estados.modelo.EstadoDto;

public interface EstadoService {

	Estado obtenerById(String id);

	Estado guardar(EstadoDto estadoDto);

	Estado modificar(String id, EstadoDto estadoDto);

	List<Estado> obtenerTodo();
	
	void remover(String id);
}

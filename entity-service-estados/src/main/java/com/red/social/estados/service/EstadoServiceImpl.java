package com.red.social.estados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.red.social.estados.entity.Estado;
import com.red.social.estados.modelo.EstadoDto;
import com.red.social.estados.repository.EstadosRepository;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class EstadoServiceImpl implements EstadoService{
	
	private EstadosRepository estadoRepository;
	
	public EstadoServiceImpl(EstadosRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}
	
	@Override
	public Estado obtenerById(String id) {
		return estadoRepository.findById(id)
				.orElseThrow(() -> EstadoNoEncontradoException.from("No se encontro estado", id));
	}

	@Override
	public Estado guardar(EstadoDto publicacionDto) {
		Estado publucacion = Estado.from(publicacionDto);
		return estadoRepository.save(publucacion);
	}

	@Override
	public Estado modificar(String id, EstadoDto publicacionDto) {
		Estado publicacion = estadoRepository.findById(id)
				.orElseThrow(() -> EstadoNoEncontradoException.from("No se encontro estado", id));

		publicacion = publicacion.from(publicacionDto);

		publicacion = estadoRepository.save(publicacion);

		return publicacion;
	}

	@Override
	public List<Estado> obtenerTodo() {

		return estadoRepository.findAll();
	}

	@Override
	public void remover(String id) {
		estadoRepository.findById(id)
				.orElseThrow(() -> EstadoNoEncontradoException.from("No se encontro estado", id));

		estadoRepository.delete(id);
	}
}

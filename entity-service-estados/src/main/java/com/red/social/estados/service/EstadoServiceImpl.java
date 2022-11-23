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
	public Estado guardar(EstadoDto estadoDto) {
		Estado publucacion = Estado.from(estadoDto);
		return estadoRepository.save(publucacion);
	}

	@Override
	public Estado modificar(String id, EstadoDto estadoDto) {
		Estado estado = estadoRepository.findById(id)
				.orElseThrow(() -> EstadoNoEncontradoException.from("No se encontro estado", id));

		estado.setId(id);
		estado.setFoto(estadoDto.getFoto());
		estado.setFecha(estadoDto.getFecha());
		estado.setDescripcion(estadoDto.getDescripcion());

		return estadoRepository.save(estado);
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

package com.red.social.publicaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.red.social.publicaciones.entity.Publicacion;
import com.red.social.publicaciones.modelo.PublicacionDto;
import com.red.social.publicaciones.repository.PublicacionesRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.red.social.publicaciones.RabbitConfigConsumer;

@Service
public class PublicacionesServiceImpl implements PublicacionesService{
	
	private PublicacionesRepository publicacionesRepository;
	
	public PublicacionesServiceImpl(PublicacionesRepository publicacionRepository) {
		this.publicacionesRepository = publicacionRepository;
	}
	
	@Override
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_PUBLICACIONES)
	public Publicacion obtenerById(String id) {
		return publicacionesRepository.findById(id)
				.orElseThrow(() -> PublicacionNoEncontradoException.from("No se encontro publicacion", id));
	}

	@Override
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_PUBLICACIONES)
	public Publicacion guardar(PublicacionDto publicacionDto) {
		Publicacion publucacion = Publicacion.from(publicacionDto);
		return publicacionesRepository.save(publucacion);
	}

	@Override
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_PUBLICACIONES)
	public Publicacion modificar(String id, PublicacionDto publicacionDto) {
		Publicacion publicacion = publicacionesRepository.findById(id)
				.orElseThrow(() -> PublicacionNoEncontradoException.from("No se encontro publicacion", id));

		publicacion.setId(id);
		publicacion.setDescripcion(publicacionDto.getDescripcion());

		return publicacionesRepository.save(publicacion);
	}

	@Override
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_PUBLICACIONES)
	public List<Publicacion> obtenerTodo() {

		return publicacionesRepository.findAll();
	}

	@Override
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_PUBLICACIONES)
	public void remover(String id) {
		publicacionesRepository.findById(id)
				.orElseThrow(() -> PublicacionNoEncontradoException.from("No se encontro publicacion", id));

		publicacionesRepository.delete(id);
	}
}

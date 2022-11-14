package com.red.social.comentarios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.red.social.comentarios.entity.Comentario;
import com.red.social.comentarios.modelo.ComentariosDto;
import com.red.social.comentarios.repository.ComentariosRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.red.social.comentarios.RabbitConfigConsumer;

@Service
public class ComentariosServiceImpl implements ComentariosService{
	
	private ComentariosRepository comentariosRepository;
	
	public ComentariosServiceImpl(ComentariosRepository comentariosRepository) {
		this.comentariosRepository = comentariosRepository;
	}
	
	@Override
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_COMENTARIOS)
	public Comentario obtenerById(String id) {
		return comentariosRepository.findById(id)
				.orElseThrow(() -> ComentarioNoEncontradoException.from("No se encontro el comentario", id));
	}

	@Override
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_COMENTARIOS)
	public Comentario guardar(ComentariosDto comentarioDto) {
		Comentario comentario = Comentario.from(comentarioDto);
		return comentariosRepository.save(comentario);
	}

	@Override
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_COMENTARIOS)
	public Comentario modificar(String id, ComentariosDto comentarioDto) {
		Comentario comentario = comentariosRepository.findById(id)
				.orElseThrow(() -> ComentarioNoEncontradoException.from("No se encontro el comentario", id));

		comentario = comentario.from(comentarioDto);

		comentario = comentariosRepository.save(comentario);

		return comentario;
	}

	@Override
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_COMENTARIOS)
	public List<Comentario> obtenerTodo() {

		return comentariosRepository.findAll();
	}

	@Override
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_COMENTARIOS)
	public void remover(String id) {
		comentariosRepository.findById(id)
				.orElseThrow(() -> ComentarioNoEncontradoException.from("No se encontro el comentario", id));

		comentariosRepository.delete(id);
	}
}

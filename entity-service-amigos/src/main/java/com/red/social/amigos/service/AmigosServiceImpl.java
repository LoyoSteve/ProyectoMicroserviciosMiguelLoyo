package com.red.social.amigos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.red.social.amigos.entity.Amigo;
import com.red.social.amigos.modelo.AmigosDto;
import com.red.social.amigos.repository.AmigosRepository;

@Service
public class AmigosServiceImpl implements AmigoService{
	
	private AmigosRepository amigosRepository;
	
	public AmigosServiceImpl(AmigosRepository amigosRepository) {
		this.amigosRepository = amigosRepository;
	}
	
	@Override
	public Amigo obtenerById(String id) {
		return amigosRepository.findById(id)
				.orElseThrow(() -> AmigoNoEncontradoException.from("No se encontro amigo", id));
	}

	@Override
	public Amigo guardar(AmigosDto amigoDto) {
		Amigo amigo = Amigo.from(amigoDto);
		return amigosRepository.save(amigo);
	}

	@Override
	public Amigo modificar(String id, AmigosDto amigosDto) {
		Amigo amigo = amigosRepository.findById(id)
				.orElseThrow(() -> AmigoNoEncontradoException.from("No se encontro amigo", id));

		amigo.setId(id);
		amigo.setIdAmigo(amigosDto.getIdAmigo());
		amigo.setIdUsuario(amigosDto.getIdUsuario());
		amigo.setRelation(amigosDto.getRelation());

		return amigosRepository.save(amigo);
	}

	@Override
	public void remover(String id) {
		amigosRepository.findById(id)
				.orElseThrow(() -> AmigoNoEncontradoException.from("No se encontro amigo", id));

		amigosRepository.delete(id);
	}
}

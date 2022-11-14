package com.red.social.publicaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.red.social.publicaciones.entity.Publicacion;
import com.red.social.publicaciones.modelo.PublicacionDto;
import com.red.social.publicaciones.repository.PublicacionesRepository;

@Service
public class PublicacionesServiceImpl implements PublicacionesService{
	
	private PublicacionesRepository publicacionesRepository;
	
	public PublicacionesServiceImpl(PublicacionesRepository publicacionRepository) {
		this.publicacionesRepository = publicacionRepository;
	}
	
	@Override
	public Publicacion obtenerById(String id) {
		return publicacionesRepository.findById(id)
				.orElseThrow(() -> PublicacionNoEncontradoException.from("No se encontro publicacion", id));
	}

	@Override
	public Publicacion guardar(PublicacionDto publicacionDto) {
		Publicacion publucacion = Publicacion.from(publicacionDto);
		return publicacionesRepository.save(publucacion);
	}

	@Override
	public Publicacion modificar(String id, PublicacionDto publicacionDto) {
		Publicacion publicacion = publicacionesRepository.findById(id)
				.orElseThrow(() -> PublicacionNoEncontradoException.from("No se encontro publicacion", id));

		publicacion = publicacion.from(publicacionDto);

		publicacion = publicacionesRepository.save(publicacion);

		return publicacion;
	}

	@Override
	public List<Publicacion> obtenerTodo() {

		return publicacionesRepository.findAll();
	}

	@Override
	public void remover(String id) {
		publicacionesRepository.findById(id)
				.orElseThrow(() -> PublicacionNoEncontradoException.from("No se encontro publicacion", id));

		publicacionesRepository.delete(id);
	}
}

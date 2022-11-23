package com.red.social.comentarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.red.social.comentarios.entity.Comentario;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentario, String> {
	Optional<Comentario> findById(String id);
}

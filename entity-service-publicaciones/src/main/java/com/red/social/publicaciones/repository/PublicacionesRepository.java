package com.red.social.publicaciones.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.red.social.publicaciones.entity.Publicacion;

@Repository
public interface PublicacionesRepository extends JpaRepository<Publicacion, String> {
	Optional<Publicacion> findById(String id);
}

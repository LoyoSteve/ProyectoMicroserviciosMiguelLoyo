package com.red.social.usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.red.social.usuarios.entity.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, String> {
	Optional<Usuario> findById(String id);
}

package com.red.social.estados.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.red.social.estados.entity.Estado;

@Repository
public interface EstadosRepository extends JpaRepository<Estado, String> {
	Optional<Estado> findById(String id);
}

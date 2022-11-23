package com.red.social.amigos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.red.social.amigos.entity.Amigo;

@Repository
public interface AmigosRepository extends JpaRepository<Amigo, String> {
	Optional<Amigo> findById(String id);
}

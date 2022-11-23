package com.red.social.publicaciones.api;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.red.social.publicaciones.service.PublicacionNoEncontradoException;

@RestControllerAdvice
public class ApiExceptionHandler {
	@Autowired
	private ObjectMapper objectMapper;

	@ExceptionHandler(PublicacionNoEncontradoException.class)
	public HttpEntity notFound(PublicacionNoEncontradoException exception) {

		HashMap<String, Object> body = new HashMap<>();
		body.put("id", exception.getId());
		body.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
}

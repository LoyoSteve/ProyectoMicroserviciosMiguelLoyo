package com.red.social.publicaciones.service;

public class PublicacionNoEncontradoException extends RuntimeException {
  private final String id;

  public PublicacionNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static PublicacionNoEncontradoException from(String message, String id) {
    return new PublicacionNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}

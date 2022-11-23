package com.red.social.estados.service;

public class EstadoNoEncontradoException extends RuntimeException {
  private final String id;

  public EstadoNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static EstadoNoEncontradoException from(String message, String id) {
    return new EstadoNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}

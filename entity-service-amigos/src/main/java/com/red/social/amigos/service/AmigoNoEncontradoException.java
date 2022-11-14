package com.red.social.amigos.service;

public class AmigoNoEncontradoException extends RuntimeException {
  private final String id;

  public AmigoNoEncontradoException(String message, String id) {
    super(message);
    this.id = id;
  }

  public static AmigoNoEncontradoException from(String message, String id) {
    return new AmigoNoEncontradoException(message, id);
  }

  public String getId() {
    return id;
  }
}

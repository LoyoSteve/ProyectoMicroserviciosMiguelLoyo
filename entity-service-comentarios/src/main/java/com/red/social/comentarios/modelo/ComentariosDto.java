package com.red.social.comentarios.modelo;

public class ComentariosDto {

	private String id;
	private String comentario;
	private String idUsuario;
	private String idPublicacion;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(String idPosteo) {
		this.idPublicacion = idPosteo;
	}
	
	
	
}

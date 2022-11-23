package com.red.social.comentarios.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.red.social.comentarios.modelo.ComentariosDto;

@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	
	@Column(name = "comentario")
	@NotBlank
	private String comentario;
	
	@Column(name = "idusuario")
	@NotBlank
	private String idUsuario;
	
	@Column(name = "idpublicacion")
	@NotBlank
	private String idPublicacion;
	
	public static Comentario from(ComentariosDto comentarioDto) {
		Comentario comentario = new Comentario();
		comentario.setComentario(comentarioDto.getComentario());
		comentario.setIdUsuario(comentarioDto.getIdUsuario());
		comentario.setIdPublicacion(comentarioDto.getIdPublicacion());

		return comentario;
	}

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

	public void setIdPublicacion(String idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	
	

}

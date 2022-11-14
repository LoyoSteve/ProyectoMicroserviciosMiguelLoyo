package com.red.social.amigos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.red.social.amigos.modelo.AmigosDto;

@Entity
@Table(name = "amigos")
public class Amigo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	
	@Column(name = "idusuario")
	@NotBlank
	private String idUsuario;
	
	@NotBlank
	private String relation;
	
	@Column(name = "idamigo")
	@NotBlank
	private String idAmigo;
	
	public static Amigo from(AmigosDto amigoDto) {
		Amigo amigo = new Amigo();
		amigo.setIdUsuario(amigoDto.getIdUsuario());
		amigo.setRelation(amigoDto.getRelation());
		amigo.setIdAmigo(amigoDto.getIdAmigo());

		return amigo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(String idAmigo) {
		this.idAmigo = idAmigo;
	}

	
	
	

}

package com.red.social.publicaciones.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.red.social.publicaciones.modelo.PublicacionDto;

@Entity
@Table(name = "publicaciones")
public class Publicacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	
	@Column(name = "descripcion")
	@NotBlank
	private String descripcion;
	
	
	public static Publicacion from(PublicacionDto publicacionDto) {
		Publicacion publicacion = new Publicacion();
		publicacion.setDescripcion(publicacionDto.getDescripcion());

		return publicacion;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	

}

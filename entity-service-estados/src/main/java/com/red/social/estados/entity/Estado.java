package com.red.social.estados.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.red.social.estados.modelo.EstadoDto;

@Entity
@Table(name = "estados")
public class Estado implements Serializable {

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
	
	@Column(name = "fecha")
	@NotBlank
	private String fecha;
	
	@Column(name = "foto")
	@NotBlank
	private String foto;
	
	public static Estado from(EstadoDto publicacionDto) {
		Estado estado = new Estado();
		estado.setDescripcion(publicacionDto.getDescripcion());
		estado.setFecha(publicacionDto.getFecha());
		estado.setFoto(publicacionDto.getFoto());

		return estado;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


	
	
	

}

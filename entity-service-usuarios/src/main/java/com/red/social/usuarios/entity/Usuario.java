package com.red.social.usuarios.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.red.social.usuarios.modelo.UsuariosDto;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	
	@Column(name = "nombre")
	@NotBlank
	private String nombre;
	
	private Integer edad;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	
	public static Usuario from(UsuariosDto usuariosDto) {
		Usuario usuario = new Usuario();
		usuario.setNombre(usuariosDto.getNombre());
		usuario.setEdad(usuariosDto.getEdad());
		usuario.setEmail(usuariosDto.getEmail());
		usuario.setPassword(usuariosDto.getPassword());

		return usuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

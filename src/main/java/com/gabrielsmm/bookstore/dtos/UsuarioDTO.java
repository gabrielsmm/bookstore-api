package com.gabrielsmm.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.gabrielsmm.bookstore.entities.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Campo USERNAME é requerido")
	private String username;
	
	@NotEmpty(message = "Campo SENHA é requerido")
	private String senha;
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(Usuario obj) {
		super();
		this.id = obj.getId();
		this.username = obj.getUsername();
		this.senha = obj.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

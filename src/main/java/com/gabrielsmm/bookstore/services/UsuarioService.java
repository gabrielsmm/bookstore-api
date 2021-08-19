package com.gabrielsmm.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielsmm.bookstore.dtos.UsuarioDTO;
import com.gabrielsmm.bookstore.entities.Usuario;
import com.gabrielsmm.bookstore.repositories.UsuarioRepository;
import com.gabrielsmm.bookstore.services.exceptions.DataIntegrityViolationException;
import com.gabrielsmm.bookstore.services.exceptions.ObjectNotFoundException;
import com.gabrielsmm.bookstore.util.Util;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = this.usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName())); //caso nao encontre retorna null
	}
	
	public Usuario findByUserSenha(UsuarioDTO obj) {
		Usuario usuario = this.usuarioRepository.findByUserSenha(obj.getUsername(), Util.md5(obj.getSenha()));
		if(usuario != null) {
			return usuario;
		} else {
			throw new ObjectNotFoundException("Usuário ou senha incorretos!");
		}
	}
	
	public List<Usuario> findAll(){
		return this.usuarioRepository.findAll();
	}
	
	public Usuario create(Usuario obj) {
		obj.setId(null); // id criado no banco
		obj.setSenha(Util.md5(obj.getSenha()));
		try {
			return this.usuarioRepository.save(obj);
		} catch(org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Nome de usuário ou e-mail já cadastrados!");
		}
	}

	public Usuario update(Integer id, Usuario usuario) {
		Usuario obj = this.findById(id);
		obj.setUsername(usuario.getUsername());
		obj.setEmail(usuario.getEmail());
		obj.setSenha(usuario.getSenha());
		return this.usuarioRepository.save(obj);
	}

	public void delete(Integer id) {
		this.findById(id);
		this.usuarioRepository.deleteById(id);
	}
}

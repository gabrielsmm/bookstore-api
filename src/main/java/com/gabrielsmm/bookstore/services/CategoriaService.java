package com.gabrielsmm.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielsmm.bookstore.entities.Categoria;
import com.gabrielsmm.bookstore.repositories.CategoriaRepository;
import com.gabrielsmm.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = this.categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); //caso nao encontre retorna null
	}
	
	public List<Categoria> findAll(){
		return this.categoriaRepository.findAll();
	}
	
}

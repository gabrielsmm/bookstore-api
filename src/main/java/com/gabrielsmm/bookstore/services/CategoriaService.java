package com.gabrielsmm.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielsmm.bookstore.entities.Categoria;
import com.gabrielsmm.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = this.categoriaRepository.findById(id);
		return obj.orElse(null); //caso nao encontre retorna null
	}
	
}

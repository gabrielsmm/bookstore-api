package com.gabrielsmm.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielsmm.bookstore.entities.Livro;
import com.gabrielsmm.bookstore.repositories.LivroRepository;
import com.gabrielsmm.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = this.livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll() {
		return this.livroRepository.findAll();
	}
}

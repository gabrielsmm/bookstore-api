package com.gabrielsmm.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gabrielsmm.bookstore.dtos.LivroDTO;
import com.gabrielsmm.bookstore.entities.Livro;
import com.gabrielsmm.bookstore.repositories.LivroRepository;
import com.gabrielsmm.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = this.livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		this.categoriaService.findById(id_cat);
		return this.livroRepository.findAllByCategoria(id_cat);
	}
	
	public Livro create(Livro obj) {
		obj.setId(null);
		return this.livroRepository.save(obj);
	}
	
	public Livro update(Integer id, LivroDTO objDto) {
		Livro obj = this.findById(id);
//		obj.setNomeAutor(objDto.getNomeAutor());
//		obj.setTexto(objDto.getTexto());
		obj.setTitulo(objDto.getTitulo());
		return this.livroRepository.save(obj);
	}
	
	public void delete(Integer id) {
		this.findById(id);
		try {
			this.livroRepository.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new com.gabrielsmm.bookstore.services.exceptions.DataIntegrityViolationException("Livro não pode ser deletado!");
		}	
	}
}

package com.gabrielsmm.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielsmm.bookstore.entities.Categoria;
import com.gabrielsmm.bookstore.entities.Livro;
import com.gabrielsmm.bookstore.entities.Usuario;
import com.gabrielsmm.bookstore.repositories.CategoriaRepository;
import com.gabrielsmm.bookstore.repositories.LivroRepository;
import com.gabrielsmm.bookstore.repositories.UsuarioRepository;
import com.gabrielsmm.bookstore.util.Util;

@Service
public class DBService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficcção Científica", "Ficcção científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");
				
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);
				
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
				
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		
		Usuario user1 = new Usuario(null, "gabrielsmm", "gabrielsmm@gmail.com", Util.md5("123gabriel"));
		Usuario user2 = new Usuario(null, "pedroserra", "pedroserra@gmail.com", Util.md5("123pedro"));
		Usuario user3 = new Usuario(null, "jorgelucas", "jorgelucas@gmail.com", Util.md5("123gabriel"));
		Usuario user4 = new Usuario(null, "1", "admin@gmail.com", Util.md5("1"));
		this.usuarioRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
	}
}

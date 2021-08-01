package com.gabrielsmm.bookstore.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabrielsmm.bookstore.entities.Categoria;
import com.gabrielsmm.bookstore.entities.Livro;
import com.gabrielsmm.bookstore.repositories.CategoriaRepository;
import com.gabrielsmm.bookstore.repositories.LivroRepository;
import com.gabrielsmm.bookstore.services.DBService;


@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

	@Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaBaseDeDados();
	}
}

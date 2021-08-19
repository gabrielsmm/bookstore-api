package com.gabrielsmm.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gabrielsmm.bookstore.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("SELECT obj FROM Usuario obj WHERE obj.username = :username and obj.senha = :senha")
	Usuario findByUserSenha(@Param(value = "username") String username, @Param(value = "senha") String senha);
	
}
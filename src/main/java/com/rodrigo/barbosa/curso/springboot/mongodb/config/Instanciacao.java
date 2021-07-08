package com.rodrigo.barbosa.curso.springboot.mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Usuario;
import com.rodrigo.barbosa.curso.springboot.mongodb.repositorio.RepositorioUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Override
	public void run(String... args) throws Exception {
		
		repositorioUsuario.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
	
		repositorioUsuario.saveAll(Arrays.asList(maria, alex, bob));
	}

}

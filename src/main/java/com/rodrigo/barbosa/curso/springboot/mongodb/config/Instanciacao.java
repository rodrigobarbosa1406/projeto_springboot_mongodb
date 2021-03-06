package com.rodrigo.barbosa.curso.springboot.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Post;
import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Usuario;
import com.rodrigo.barbosa.curso.springboot.mongodb.dto.AutorDTO;
import com.rodrigo.barbosa.curso.springboot.mongodb.dto.ComentarioDTO;
import com.rodrigo.barbosa.curso.springboot.mongodb.repositorio.RepositorioPost;
import com.rodrigo.barbosa.curso.springboot.mongodb.repositorio.RepositorioUsuario;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPost repositorioPost;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repositorioUsuario.deleteAll();
		repositorioPost.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		repositorioUsuario.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços", new AutorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));
		
		ComentarioDTO comentario1 = new ComentarioDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AutorDTO(alex));
		ComentarioDTO comentario2 = new ComentarioDTO("Aproveite!", sdf.parse("22/03/2018"), new AutorDTO(bob));
		ComentarioDTO comentario3 = new ComentarioDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AutorDTO(alex));
		
		post1.getComentarios().addAll(Arrays.asList(comentario1, comentario2));
		post2.getComentarios().addAll(Arrays.asList(comentario3));
		repositorioPost.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		repositorioUsuario.save(maria);
	}

}

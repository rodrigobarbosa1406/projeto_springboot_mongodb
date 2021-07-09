package com.rodrigo.barbosa.curso.springboot.mongodb.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Post;
import com.rodrigo.barbosa.curso.springboot.mongodb.repositorio.RepositorioPost;
import com.rodrigo.barbosa.curso.springboot.mongodb.servicos.exception.ObjectNotFoundException;

@Service
public class ServicoPost {

	@Autowired
	private RepositorioPost repositorioPost;
	
	public Post buscarPorId(String id) {
		Optional<Post> post = repositorioPost.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}

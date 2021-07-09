package com.rodrigo.barbosa.curso.springboot.mongodb.recursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Post;
import com.rodrigo.barbosa.curso.springboot.mongodb.servicos.ServicoPost;

@RestController
@RequestMapping(value = "/posts")
public class RecursoPost {
	
	@Autowired
	private ServicoPost servicoPost;
		
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> buscarPorId(@PathVariable String id){
		Post post = servicoPost.buscarPorId(id);
		
		return ResponseEntity.ok().body(post);
	}
}

package com.rodrigo.barbosa.curso.springboot.mongodb.recursos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Post;
import com.rodrigo.barbosa.curso.springboot.mongodb.recursos.util.URL;
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
	
	@RequestMapping(value="/buscartitulo", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> buscarPorTitulo(@RequestParam(value="texto", defaultValue="") String valor){
		valor = URL.decodeParam(valor);
		List<Post> posts = servicoPost.buscarPorTitulo(valor);
		
		return ResponseEntity.ok().body(posts);
	}
	
	@RequestMapping(value="/buscartudo", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> buscarTudo(
			@RequestParam(value="texto", defaultValue="") String valor,
			@RequestParam(value="dtIni", defaultValue="") String dtIni,
			@RequestParam(value="dtFim", defaultValue="") String dtFim){
		valor = URL.decodeParam(valor);
		
		Date dtIniC = URL.converteData(dtIni, new Date(0L));
		Date dtFimC = URL.converteData(dtFim, new Date());
		
		List<Post> posts = servicoPost.buscarTudo(valor, dtIniC, dtFimC);
		
		return ResponseEntity.ok().body(posts);
	}
}

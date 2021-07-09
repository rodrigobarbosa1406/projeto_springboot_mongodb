package com.rodrigo.barbosa.curso.springboot.mongodb.servicos;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> buscarPorTitulo(String valor){
		return repositorioPost.buscarPorTitulo(valor);
	}
	
	public List<Post> buscarTudo(String valor, Date dtIni, Date dtFim){
		return repositorioPost.buscarTudo(valor, dtIni, (new Date(dtFim.getTime() + (24*60*60*1000))));
	}
}

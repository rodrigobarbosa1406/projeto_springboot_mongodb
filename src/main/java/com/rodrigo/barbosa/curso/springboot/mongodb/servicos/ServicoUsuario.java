package com.rodrigo.barbosa.curso.springboot.mongodb.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Usuario;
import com.rodrigo.barbosa.curso.springboot.mongodb.repositorio.RepositorioUsuario;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	public List<Usuario> buscarTodos(){
		return repositorioUsuario.findAll();
	}
}

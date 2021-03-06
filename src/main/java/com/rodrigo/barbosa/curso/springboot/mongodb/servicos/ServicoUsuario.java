package com.rodrigo.barbosa.curso.springboot.mongodb.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Usuario;
import com.rodrigo.barbosa.curso.springboot.mongodb.dto.UsuarioDTO;
import com.rodrigo.barbosa.curso.springboot.mongodb.repositorio.RepositorioUsuario;
import com.rodrigo.barbosa.curso.springboot.mongodb.servicos.exception.ObjectNotFoundException;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	public List<Usuario> buscarTodos(){
		return repositorioUsuario.findAll();
	}
	
	public Usuario buscarPorId(String id) {
		Optional<Usuario> usuario = repositorioUsuario.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Usuario inserir(Usuario usuario) {
		return repositorioUsuario.insert(usuario);
	}
	
	public void excluir(String id) {
		buscarPorId(id);
		repositorioUsuario.deleteById(id);
	}
	
	public Usuario atualizar(Usuario usuario) {
		Usuario novoUsuario = buscarPorId(usuario.getId());
		atualizarDados(novoUsuario, usuario);
		
		return repositorioUsuario.save(novoUsuario);
	}
	
	private Usuario atualizarDados(Usuario novoUsuario, Usuario usuario) {
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setEmail(usuario.getEmail());
		
		return novoUsuario;
	}

	public Usuario fromDTO(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getEmail());
	}
}

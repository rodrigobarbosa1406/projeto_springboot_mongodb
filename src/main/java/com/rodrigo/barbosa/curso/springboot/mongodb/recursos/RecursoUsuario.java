package com.rodrigo.barbosa.curso.springboot.mongodb.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Usuario;
import com.rodrigo.barbosa.curso.springboot.mongodb.dto.UsuarioDTO;
import com.rodrigo.barbosa.curso.springboot.mongodb.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servicoUsuario;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
		List<Usuario> usuarios = servicoUsuario.buscarTodos();
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(usuariosDTO);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable String id){
		Usuario usuario = servicoUsuario.buscarPorId(id);
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}
}

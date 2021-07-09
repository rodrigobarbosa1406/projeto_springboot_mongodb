package com.rodrigo.barbosa.curso.springboot.mongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	private Date data;
	private AutorDTO autor;
	
	public ComentarioDTO() {
	}

	public ComentarioDTO(String mensagem, Date data, AutorDTO autor) {
		this.mensagem = mensagem;
		this.data = data;
		this.autor = autor;
	}

	public String getTexto() {
		return mensagem;
	}

	public void setTexto(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
}

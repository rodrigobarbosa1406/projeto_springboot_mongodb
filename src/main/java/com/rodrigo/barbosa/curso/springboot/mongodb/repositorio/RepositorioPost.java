package com.rodrigo.barbosa.curso.springboot.mongodb.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Post;

@Repository
public interface RepositorioPost extends MongoRepository<Post, String> {

	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Post> buscarPorTitulo(String valor);
	
	List<Post> findByTituloContainingIgnoreCase(String valor);
	
	@Query("{ "
			+ "		$and: [ "
			+ "				{"
			+ "					data: {$gte: ?1} "
			+ "				}, "
			+ "				{"
			+ "					data: {$lte: ?2} "
			+ "				}, "
			+ "				{ "
			+ "					$or: [ "
			+ "							{"
			+ "								'titulo': { $regex: ?0, $options: 'i'}"
			+ "							}, "
			+ "							{"
			+ "								'mensagem': { $regex: ?0, $options: 'i'} "
			+ "							}, "
			+ "							{"
			+ "								'comentarios.text': { $regex: ?0, $options: 'i'}"
			+ "							} "
			+ "						]"
			+ "				}"
			+ "			]"
			+ "}"
			)
	List<Post> buscarTudo(String valor, Date dtIni, Date dtFim);
}
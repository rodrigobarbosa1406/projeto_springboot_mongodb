package com.rodrigo.barbosa.curso.springboot.mongodb.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.barbosa.curso.springboot.mongodb.dominio.Post;

@Repository
public interface RepositorioPost extends MongoRepository<Post, String> {

}

// SEMANA 7 - BLOCO 2 - 24/03/22
// INTRODUÇÃO À BANCO DE DADOS COM MYSQL
// MODEL, REPOSITORY E CONTROLLER


package org.generation.blogpessoalaula.repository;

import java.util.List;

import org.generation.blogpessoalaula.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository; // herança de uma outra interface, necessita de identificação dos parâmetros trabalhados
import org.springframework.stereotype.Repository;

// declarar nos parâmetros soliciados nos extends: tipo de entidade trabalhada (nome do model) e tipo de chave primária (Long na versão primitiva)

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	//consultas
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	//methods query -> busca todos os títulos contidos, igr letras maiúsculas e minúsculas
	//:: a interface jpa para consultas no bd é limitada, sendo necessário criar/construir "metodos query" para consultas organizadas
}

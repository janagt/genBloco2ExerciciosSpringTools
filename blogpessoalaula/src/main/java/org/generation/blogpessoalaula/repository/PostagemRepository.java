// SEMANA 7 - BLOCO 2 - 24/03/22 E 25/03/22
// INTRODUÇÃO AO SPRING BOOT
// MODEL, REPOSITORY E CONTROLLER
// GET, POST, PUT E DELETE 

/* 	
 * 	REPOSITORY
 * 
 *  Tudo que precisa para fazer consulta ao baco de dados (consulta por id, por título, por id de usuário) vai ficar nela.
 *  É o repositório de consulta no banco de dados.
 */

package org.generation.blogpessoalaula.repository;

import java.util.List;

import org.generation.blogpessoalaula.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository; // herança de uma outra interface, necessita de identificação dos parâmetros trabalhados
import org.springframework.stereotype.Repository;


@Repository // Indica que a interface é um repositório
public interface PostagemRepository extends JpaRepository<Postagem, Long>{ // É interface pois herda atributos de uma superclasse
	
	/* 
	 * Declarar nos parâmetros soliciados nos extends: tipo de entidade trabalhada (a do model) e tipo de chave primária (Long na versão referência)
	 * Dentro de interface do Jpa hibernate temos vários contratos que permitem fazer manipulação no banco de dados, um que irá selecionar tudo (FindAll), seleciona um dado pelo id (FindById), (Save), (Delete). 
	 * Existem manipulações que não estão dentro desta interface, mas através dos query metodhs faremos nossa consultas padronizadas (que nós mesmos iremos construir).
	 */
	
	// Consulta pelo título da postagem
	
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	// Vai exibir uma lista de postagens com a ação do metodo (que é o mesmo nome) com os parâmetros de onde vem a busca, no caso a String titulo

	// Methods Query -> Busca todos os títulos contidos, ignora letras maiúsculas e minúsculas :: a interface jpa para consultas no banco de dados é limitada, sendo necessário criar/construir "metodos query" para consultas organizadas
}
// SEMANA 7 - BLOCO 2 - 24/03/22
// INTRODUÇÃO À BANCO DE DADOS COM MYSQL
// MODEL, REPOSITORY E CONTROLLER


package org.generation.blogpessoalaula.controller;

import java.util.List;

import org.generation.blogpessoalaula.model.Postagem;
import org.generation.blogpessoalaula.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica que esta classe é um controller
@RequestMapping("/postagens") // postagens é uma uri (endpoint) essa classe será acessada. QUando vier uma requisição para /postagens, a requisição consumirá  essa classe - Cria uma rota de requisição para a API 
@CrossOrigin("*") // o "*" indica que a API aceitará a requisição (aplicação front-end) de qualquer origem
public class PostagemController {
	
	@Autowired // "direcionamento de dependência" direcionamento da responsabilidade de instanciação da interface para o STS (serviços da interface -> postagem repository acessado a partir do controller)
	private PostagemRepository repository; // inclui a classe repository
	
	//METODO
	
	@GetMapping // sempre que tiver requisição externa, através da "/postagens" se o método for GET, será iniciado o comando descrito
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
}

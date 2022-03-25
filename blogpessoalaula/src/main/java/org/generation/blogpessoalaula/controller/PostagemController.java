// SEMANA 7 - BLOCO 2 - 24/03/22 E 25/03/22
// INTRODUÇÃO AO SPRING BOOT
// MODEL, REPOSITORY E CONTROLLER
// GET, POST, PUT E DELETE 

/*
 * CONTROLLER
 * 
 * Camada controladora da aplicação, onde estão endpoints e funções.
 * É a camada que exerce controle dos endpoints (as funções da API, os endereços delas) da aplicação.
 */


package org.generation.blogpessoalaula.controller;

import java.util.List;

import org.generation.blogpessoalaula.model.Postagem;
import org.generation.blogpessoalaula.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe é uma controladora
@RequestMapping("/postagens") // Informa qual URI essa classe vai ser acessada, com o endpoint de Parâmetro (Postagens é uma uri (endpoint) quando vier uma requisição para /postagens, a requisição irá acessar essa classe, criando uma rota de requisição para a API)
@CrossOrigin("*") // O "*" permite que o controller possa ser acessado por qualquer porta (Indica que a API aceitará a requisição (aplicação front-end) de qualquer origem/porta)
public class PostagemController {
	
	@Autowired // "direcionamento de dependência" direcionamento da responsabilidade de instanciação da interface pelo spring o repositório abaixo no controller, isso permite que todos os serviços de PostagemRepository fique acessível em controller através do apelido dado (o repository)
	private PostagemRepository repository; // puxa o repositório dentro de controle, chamando o nome, depois dando um "apelido"
	
	
	// METODOS
	
	// GET - Primerio método, o geral
	@GetMapping // Vai iniciar o método abaixo sempre que tiver requisição externa, através da "/postagens" quando o verbo solicitado for GET
	public ResponseEntity<List<Postagem>> GetAll(){
		// Vai puxar uma lista trazendo todas as postagens
		return ResponseEntity.ok(repository.findAll());
		// Vai retornar essa ResponseEntity com o erro de 200 OK, procurando por todos, dentro do apelido
	}
	
	// GET - Segundo método, de ID
	@GetMapping("/{id}") // Permite outra requisição de verbo GET com consulta diferente
	public ResponseEntity<Postagem> GetById(@PathVariable Long id){ // Como a pesquisa é por ID, só retornará um objeto. Vai pegar um id do tipo Long com nome id, onde o valor dessa variável vem como o caminho de GetMapping
		return repository.findById(id) // Retorna um Optional, podendo ser tanto populado quanto nulo
				.map(resp -> ResponseEntity.ok(resp)) // Se for populado: metodo map para capturar, usando uma land expression (resp) e retorna 200 OK
				.orElse(ResponseEntity.notFound().build()); // Se não for populado: retorna o 400 NOT FOUND
	}
	
	// GET - Terceiro método, de título
	@GetMapping("/titulo/{titulo}") // Para não ter endpoints repetidos, adicionamos uma subpagina /titulo
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){ // Mesma coisa que o ID, mas exibindo uma lista
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo)); // Vai buscar o que contém no título e trazer uma lista de postagens com a palavra buscada
	}
	
	// POST - Novo método, de postagem
	@PostMapping // A notação é passada o objeto/recurso (que recebe), pois é pego pela BODY, que pega o que vem no CORPO da requisição
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){ // post é o nome do método, responsável por enviar uma postagem, passando um objeto do tipo postagem com o nome de postagem (vai puxar em forma de objeto a Postagem.java que demos o nome de postagem através do TABLE). 
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem)); // Vai salvar de fato a postagem e devolverá na BODY. Cria endpoint de postagem
	}
	
	// PUT - Novo método, de atualização
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){ // Igual ao POST
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem)); // Mesmo sendo igual, ele é responsável por atualizar o que criamos com POST. Devemos passar também o ID junto com as informações alteradas.
	}
	
	// DELETE - Novo método, de exclusão
	@DeleteMapping("/{id}") // Puxa através da interpolação no endpoint que será deletado
	public void delete(@PathVariable Long id) { // PathVariable por que ele vai puxar o que vem do atributo, o mesmo do endpoint. Void pois não irá retornar nada
		repository.deleteById(id); // Id de parâmetro que é recebido pelo pathvariable
	}
}


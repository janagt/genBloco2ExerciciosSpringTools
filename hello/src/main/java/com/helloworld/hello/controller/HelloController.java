package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 					// indica que a classe é um controle e importa a biblioteca
public class HelloController {
	
	@RequestMapping("/hello")		// indica para o postman/insomnia uma string (endpoint)
	public String hello() {			// indica no postman/insomnia a mensagem
		return "Hello Generation!!!";
	}
	
	@GetMapping ("/bsm")
	public String bsm() {			// indica no postman/insomnia a mensagem
		return "BSM Generation!!!\n\nHabilidades:\n[1] Trabalho em equipe\n[2] Atenção aos detalhe\n[3] Proatividade\n[4] Comunicação"
				+ "\n\nMentalidades:\n[1] Orientação ao Futuro\n[2] Responsabilidade Pessoal\n[3] Mentalidade de Crescimento\n[4] Persistência";
	}

	@GetMapping ("/objetivos")
	public String objetivos() {		// indica no postman/insomnia a mensagem
		return "Objetivos Generation!!!\n\nAprender mais sobre:\n[1] Springboot\n[2] Postman\n\nRevisar:\n[1] MySQL\n[2] POO";
	}
}

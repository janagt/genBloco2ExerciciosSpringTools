package com.halloworld.hallo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 					// indica que a classe é um controle e importa a biblioteca
@RequestMapping("/hallo")			// indica para o postman/insomnia uma string
public class HalloController {
	
	@GetMapping
	public String hello() {			// indica no postman/insomnia a mensagem
		return "Hallo Generation!!!";
	}

}

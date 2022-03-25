// SEMANA 7 - BLOCO 2 - 24/03/22
// INTRODUÇÃO À BANCO DE DADOS COM MYSQL
// MODEL, REPOSITORY E CONTROLLER


package org.generation.blogpessoalaula.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // transforma em tabela
@Table(name= "postagem") // nomeia a tabela
public class Postagem {
	
	@Id // informa que é ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // base de dados = chave primária com auto incremento
	private Long id; // Long (forma primitiva) é equivalente ao bigint do mysql
	
	@NotNull // não permite que o campo fique em branco
	@Size(min=5,max=100) // limita o campo em mínimo 5 e máximo 100 de caracteres (letras)
	private String titulo;
	
	@NotNull
	@Size(min=10,max=500)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP) // responsável por importar a data
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	// GET E SET

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
}

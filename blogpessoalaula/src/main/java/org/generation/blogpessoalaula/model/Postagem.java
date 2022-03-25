// SEMANA 7 - BLOCO 2 - 24/03/22 E 25/03/22
// INTRODUÇÃO AO SPRING BOOT
// MODEL, REPOSITORY E CONTROLLER
// GET, POST, PUT E DELETE 

/*
 * MODEL
 * 
 * Estrutura/modela dados no banco de dados
 */


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

@Entity // Indica que é uma tabela
@Table(name= "postagem") // Nomeia a tabela
public class Postagem {
	
	@Id // Informa que é chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Monta o auto increment. Passando uma estratégia para a geração de valor.
	private Long id; // Long (forma primitiva) é equivalente ao bigint do mysql
	
	@NotNull // Não permite que o campo fique nulo. Importa de validation (por dentro do pom.xml em dependencies)
	@Size(min=5,max=100) // Limita o campo em mínimo 5 e máximo 100 de caracteres (letras)
	private String titulo;
	
	@NotNull
	@Size(min=10,max=500)
	private String texto;
	//importar a data.
	@Temporal(TemporalType.TIMESTAMP) // Responsável por indicar pro jpa hibernate que estamos trabalhando com tempo, dentro do parâmetro colocamos o tipo do tempo
	private Date data = new java.sql.Date(System.currentTimeMillis()); //  Indica que assim que for lançado a postagem, o java.sql vai pegar a data atual com o segundo e milésimo que o dado pessou pela classe.
	
	
	// GET E SET
	
	/*
	 * Para funcionar o que fizemos, para gente atualizar a tabela e os dados dessa tabela para trazer pra consulta ou mandar, precisa definir os métodos getters e setters dos atributos.
	 */
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

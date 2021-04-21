package main.java.modelo.identificacao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Identificacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7116146274804014963L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idIdentificacao;
	private String nomeFantasia;
	private String razaoSocial;
	private String nomePessoaFisica;
	private String cpf;
	private String cnpj;
	
}

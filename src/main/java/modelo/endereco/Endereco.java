package main.java.modelo.endereco;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.enumeracao.UnidadeFederativa;

@NoArgsConstructor
@Data
@Entity
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1502740742344711586L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEndereco;
	private String rua;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String referencia;
	private String cidade;
	private UnidadeFederativa unidadeFederativa;
	private String pais;

}

package main.java.modelo.fornecedor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.modelo.contato.Contato;
import main.java.modelo.endereco.Endereco;
import main.java.modelo.identificacao.Identificacao;

@NoArgsConstructor
@Data
@Entity
public class Fornecedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2179647641229615168L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFornecedor;
	@OneToOne(fetch = FetchType.EAGER)
	private Identificacao identificacaoFornecedor;
	@OneToOne(fetch = FetchType.EAGER)
	private Contato contatoFornecedor;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "enderecos_fornecedor")
	private List<Endereco> enderecosFornecedor;

}

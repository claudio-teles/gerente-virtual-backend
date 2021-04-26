package main.java.modelo.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.modelo.fornecedor.Fornecedor;

@NoArgsConstructor
@Data
@Entity
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4240018116565795221L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProduto;
	private String indentificadorProduto;
	private String localEstaGuardado;
	private String nomeDoProduto;
	private String descricao;
	private String fabricante;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Fornecedor> fornecedoresProduto;
	private String fotoProduto;
	private Long quantidadeProduto;
	
	private BigDecimal precoAvista;
	private BigDecimal precoParcelado;
	
	public Produto(String localEstaGuardado, String nomeDoProduto, String descricao, String fabricante,
			Set<Fornecedor> fornecedoresProduto, String fotoProduto, BigDecimal precoAvista,
			BigDecimal precoParcelado) {
		super();
		this.localEstaGuardado = localEstaGuardado;
		this.nomeDoProduto = nomeDoProduto;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.fornecedoresProduto = fornecedoresProduto;
		this.fotoProduto = fotoProduto;
		this.precoAvista = precoAvista;
		this.precoParcelado = precoParcelado;
	}

	public Produto(String indentificadorProduto, String localEstaGuardado, String nomeDoProduto, String descricao,
			String fabricante, Set<Fornecedor> fornecedoresProduto, String fotoProduto, BigDecimal precoAvista,
			BigDecimal precoParcelado) {
		super();
		this.indentificadorProduto = indentificadorProduto;
		this.localEstaGuardado = localEstaGuardado;
		this.nomeDoProduto = nomeDoProduto;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.fornecedoresProduto = fornecedoresProduto;
		this.fotoProduto = fotoProduto;
		this.precoAvista = precoAvista;
		this.precoParcelado = precoParcelado;
	}

}

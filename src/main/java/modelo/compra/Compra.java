package main.java.modelo.compra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.enumeracao.FormaPagemento;
import main.java.modelo.fornecedor.Fornecedor;
import main.java.modelo.mercadoria.Mercadoria;
import main.java.modelo.outro.Outro;
import main.java.modelo.peca.Peca;
import main.java.modelo.produto.Produto;

@NoArgsConstructor
@Data
@Entity
public class Compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4613245537877035903L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCompra;
	private Calendar dataCompra;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	private Fornecedor fornecedor;
	
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Mercadoria> mercadorias;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Produto> produtos;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Peca> pecas;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Outro> outros;
	private BigDecimal valorCompra;
	private FormaPagemento formaPagemento;
	private Integer numeroParcelas;
	
	public Compra(Calendar dataCompra, Fornecedor fornecedor) {
		super();
		this.dataCompra = dataCompra;
		this.fornecedor = fornecedor;
	}

	public Compra(Calendar dataCompra, Fornecedor fornecedor, Set<Mercadoria> mercadorias) {
		super();
		this.dataCompra = dataCompra;
		this.fornecedor = fornecedor;
		this.mercadorias = mercadorias;
	}

	public Compra(Calendar dataCompra, Fornecedor fornecedor, Set<Mercadoria> mercadorias, Set<Produto> produtos,
			Set<Peca> pecas, Set<Outro> outros) {
		super();
		this.dataCompra = dataCompra;
		this.fornecedor = fornecedor;
		this.mercadorias = mercadorias;
		this.produtos = produtos;
		this.pecas = pecas;
		this.outros = outros;
	}

}

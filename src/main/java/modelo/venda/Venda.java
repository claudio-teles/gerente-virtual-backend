package main.java.modelo.venda;

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
import main.java.modelo.mercadoria.Mercadoria;
import main.java.modelo.outro.Outro;
import main.java.modelo.peca.Peca;
import main.java.modelo.produto.Produto;
import main.java.modelo.vendedor.Vendedor;

@NoArgsConstructor
@Data
@Entity
public class Venda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3919626273705563733L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVenda;
	private Calendar dataVenda;
	@OneToOne(fetch = FetchType.EAGER)
	private Vendedor vendedor;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Mercadoria> mercadorias;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Produto> produtos;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Peca> pecas;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Outro> outros;
	private BigDecimal valorVenda;
	private FormaPagemento formaPagemento;
	private Integer numeroParcelas;

}

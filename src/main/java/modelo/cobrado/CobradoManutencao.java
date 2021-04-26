package main.java.modelo.cobrado;

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
import main.java.enumeracao.FormaPagemento;
import main.java.modelo.outro.Outro;
import main.java.modelo.peca.Peca;
import main.java.modelo.produto.Produto;

@NoArgsConstructor
@Data
@Entity
public class CobradoManutencao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1306776419671985901L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCobradoManutencao;
	private String descricaoServicofeito;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Peca> pecas;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Produto> produtos;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Outro> outros;
	private BigDecimal valorConserto;
	private FormaPagemento formaPagemento;
	private Integer numeroParcelas;

}

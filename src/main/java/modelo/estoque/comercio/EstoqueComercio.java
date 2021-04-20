package main.java.modelo.estoque.comercio;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.enumeracao.SubSetorComercio;
import main.java.modelo.fornecedor.Fornecedor;

@NoArgsConstructor
@Data
@Entity
public class EstoqueComercio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 737913227964755929L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMercadoriaEstoqueComercio;
	private String codigoBarraMercadoria;
	private String nomeMercadoria;
	private String descricaoCaracteristicasMercadoria;
	private String nomeFabricanteMercadoria;
	private BigDecimal precoMercadoriaComprada;
	private BigDecimal precoVistaMercadoria;
	private BigDecimal precoParceladoMercadoria;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAquisicaoMercadoria;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataVencimentoMercadoria;
	private SubSetorComercio subSetorComercio;
	private Long quantidadeMercadoriaEstoque;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Fornecedor> fornecedoresMercadoria;

}

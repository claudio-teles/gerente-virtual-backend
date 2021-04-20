package main.java.modelo.mercadoria;

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
public class Mercadoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6009207429453325907L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMercadoria;
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
	
	public Mercadoria(String codigoBarraMercadoria, String nomeMercadoria, String descricaoCaracteristicasMercadoria,
			String nomeFabricanteMercadoria, BigDecimal precoMercadoriaComprada, BigDecimal precoVistaMercadoria,
			BigDecimal precoParceladoMercadoria, Calendar dataAquisicaoMercadoria, Calendar dataVencimentoMercadoria,
			SubSetorComercio subSetorComercio, Long quantidadeMercadoriaEstoque,
			Set<Fornecedor> fornecedoresMercadoria) {
		super();
		this.codigoBarraMercadoria = codigoBarraMercadoria;
		this.nomeMercadoria = nomeMercadoria;
		this.descricaoCaracteristicasMercadoria = descricaoCaracteristicasMercadoria;
		this.nomeFabricanteMercadoria = nomeFabricanteMercadoria;
		this.precoMercadoriaComprada = precoMercadoriaComprada;
		this.precoVistaMercadoria = precoVistaMercadoria;
		this.precoParceladoMercadoria = precoParceladoMercadoria;
		this.dataAquisicaoMercadoria = dataAquisicaoMercadoria;
		this.dataVencimentoMercadoria = dataVencimentoMercadoria;
		this.subSetorComercio = subSetorComercio;
		this.quantidadeMercadoriaEstoque = quantidadeMercadoriaEstoque;
		this.fornecedoresMercadoria = fornecedoresMercadoria;
	}
	
}

package main.java.modelo.ordemservico;

import java.io.Serializable;
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
import main.java.enumeracao.StatusOrdemServico;
import main.java.modelo.cliente.Cliente;
import main.java.modelo.empreendimento.Empreendimento;
import main.java.modelo.outro.Outro;
import main.java.modelo.peca.Peca;
import main.java.modelo.produto.Produto;

@NoArgsConstructor
@Data
@Entity
public class OrdemServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3678789353814519908L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idOrdemServico;
	@OneToOne(fetch = FetchType.EAGER)
	private Empreendimento empreendimento;
	private Calendar dataAberturaOS;
	private Calendar dataPrevisaoTerminoOS;
	private Calendar dataFinalizacaoOS;
	private Calendar dataInicioGarantia;
	private Calendar dataTerminoGarantia;
	@OneToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	private StatusOrdemServico statusOrdemServico;
	private FormaPagemento formaPagemento;
	private String descricaoDefeito;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Peca> pecas;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Produto> produtos;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Outro> outros;
	private String observacao;

}

package main.java.modelo.ordemservico;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.enumeracao.FormaPagemento;
import main.java.enumeracao.StatusOrdemServico;
import main.java.modelo.cliente.Cliente;
import main.java.modelo.cobrado.CobradoManutencao;
import main.java.modelo.empreendimento.Empreendimento;

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
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	private Empreendimento empreendimento;
	private Calendar dataAberturaOS;
	private Calendar dataPrevisaoTerminoOS;
	private Calendar dataFinalizacaoOS;
	private Calendar dataInicioGarantia;
	private Calendar dataTerminoGarantia;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	private Cliente cliente;
	private StatusOrdemServico statusOrdemServico;
	private FormaPagemento formaPagemento;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	private CobradoManutencao itemCobradoManutencao;
	private String observacao;

}

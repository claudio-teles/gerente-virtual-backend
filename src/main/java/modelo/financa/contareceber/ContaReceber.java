package main.java.modelo.financa.contareceber;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.modelo.venda.Venda;

@NoArgsConstructor
@Data
@Entity
public class ContaReceber implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6328350349120057570L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idContaReceber;
	private BigDecimal valorRecebido;
	private Calendar dataRecebimento;
	private Integer numeroParcelasRestantes;
	@OneToOne(fetch = FetchType.EAGER)
	private Venda venda;

}

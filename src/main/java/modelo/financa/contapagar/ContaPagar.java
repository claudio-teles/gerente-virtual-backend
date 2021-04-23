package main.java.modelo.financa.contapagar;

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
import main.java.modelo.compra.Compra;

@NoArgsConstructor
@Data
@Entity
public class ContaPagar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7605593551463657928L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idContaPagar;
	private BigDecimal valorPago;
	private Calendar dataPagamento;
	private Integer numeroParcelasRestantes;
	@OneToOne(fetch = FetchType.EAGER)
	private Compra compra;
	private String outroGasto;

}

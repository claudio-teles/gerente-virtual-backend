package main.java.modelo.financa.saidadinheiro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class SaidaDinheiro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6337978060840655835L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSaidaDinheiro;
	private BigDecimal quantiaNoFinalDia;
	private Calendar dataSaidaFimDia;

}

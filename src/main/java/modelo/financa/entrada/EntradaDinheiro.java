package main.java.modelo.financa.entrada;

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
public class EntradaDinheiro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1393522877586541704L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEntradaDinheiro;
	private BigDecimal quantiaNoFinalDia;
	private Calendar dataEntradaFimDia;

}

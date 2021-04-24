package main.java.modelo.cliente;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.modelo.contato.Contato;
import main.java.modelo.endereco.Endereco;
import main.java.modelo.identificacao.Identificacao;

@NoArgsConstructor
@Data
@Entity
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6314315555856832717L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCliente;
	@OneToOne(fetch = FetchType.EAGER)
	private Identificacao identificacao;
	@OneToOne(fetch = FetchType.EAGER)
	private Endereco endereco;
	@OneToOne(fetch = FetchType.EAGER)
	private Contato contato;
	private Integer idade;

}

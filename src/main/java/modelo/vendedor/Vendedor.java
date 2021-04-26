package main.java.modelo.vendedor;

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
public class Vendedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1217119587402509084L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVendedor;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	private Identificacao identificacao;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	private Endereco endereco;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	private Contato contato;

}

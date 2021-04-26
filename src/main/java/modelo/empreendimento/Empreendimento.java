package main.java.modelo.empreendimento;

import java.io.Serializable;
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
import main.java.modelo.contato.Contato;
import main.java.modelo.endereco.Endereco;
import main.java.modelo.identificacao.Identificacao;
import main.java.modelo.tecnico.Tecnico;
import main.java.modelo.vendedor.Vendedor;

@NoArgsConstructor
@Data
@Entity
public class Empreendimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7474251910802642149L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEmpreendimento;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	private Identificacao identificacao;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	private Endereco endereco;
	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	private Contato contato;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Vendedor> vendedores;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Tecnico> tecnicos;

}

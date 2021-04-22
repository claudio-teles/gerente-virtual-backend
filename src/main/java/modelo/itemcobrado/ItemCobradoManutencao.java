package main.java.modelo.itemcobrado;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.modelo.outro.Outro;
import main.java.modelo.peca.Peca;
import main.java.modelo.produto.Produto;

@NoArgsConstructor
@Data
@Entity
public class ItemCobradoManutencao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7319758768601717836L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idItensCobradosManutencao;
	private String descricaoServicofeito;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Peca> pecas;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Produto> produtos;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Outro> outros;

}

package main.java.modelo.estoque.manutencao;

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
public class EstoqueManutencao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8245669748162522571L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEstoqueManutencao;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Peca> pecas;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Produto> produtos;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Outro> outros;

}

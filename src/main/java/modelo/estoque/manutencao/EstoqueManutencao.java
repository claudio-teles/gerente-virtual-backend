package main.java.modelo.estoque.manutencao;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
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
	@ElementCollection
	private Map<Integer, Peca> pecas;
	@ElementCollection
	private Map<Integer, Produto> produtos;

}

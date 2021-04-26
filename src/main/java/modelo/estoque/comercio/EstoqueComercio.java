package main.java.modelo.estoque.comercio;

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
import main.java.modelo.mercadoria.Mercadoria;

@NoArgsConstructor
@Data
@Entity
public class EstoqueComercio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 737913227964755929L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEstoqueComercio;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Mercadoria> mercadorias;

}

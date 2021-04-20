package main.java.modelo.peca;

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
import main.java.modelo.fornecedor.Fornecedor;

@NoArgsConstructor
@Data
@Entity
public class Peca implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2735440489746636722L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPeca;
	private String codigoPeca;
	private String localEstaGuardado;
	private String nomeDaPeca;
	private String descricao;
	private String fabricante;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Fornecedor> fornecedoresPeca;
	private String fotoPeca;
	private Long quantidadePeca;

}

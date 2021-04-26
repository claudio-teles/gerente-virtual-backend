package main.java.modelo.outro;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Outro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8044355215280822315L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idOutro;
	private String indentificador;
	private String localOndeGuardado;
	private String nome;
	private String descricao;
	private String fabricante;
	private Long quantidadeOutro;
	
	private BigDecimal precoAvista;
	private BigDecimal precoParcelado;
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Fornecedor> fornecedoresOutros;
	private String fotoOutro;
	
	public Outro(String localOndeGuardado, String nome, String descricao, String fabricante, BigDecimal precoAvista,
			BigDecimal precoParcelado, Set<Fornecedor> fornecedoresOutros, String fotoOutro) {
		super();
		this.localOndeGuardado = localOndeGuardado;
		this.nome = nome;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.precoAvista = precoAvista;
		this.precoParcelado = precoParcelado;
		this.fornecedoresOutros = fornecedoresOutros;
		this.fotoOutro = fotoOutro;
	}

	public Outro(String indentificador, String localOndeGuardado, String nome, String descricao, String fabricante,
			BigDecimal precoAvista, BigDecimal precoParcelado, Set<Fornecedor> fornecedoresOutros, String fotoOutro) {
		super();
		this.indentificador = indentificador;
		this.localOndeGuardado = localOndeGuardado;
		this.nome = nome;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.precoAvista = precoAvista;
		this.precoParcelado = precoParcelado;
		this.fornecedoresOutros = fornecedoresOutros;
		this.fotoOutro = fotoOutro;
	}

}

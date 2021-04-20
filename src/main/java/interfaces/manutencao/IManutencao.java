package main.java.interfaces.manutencao;

import java.io.Serializable;

import main.java.modelo.estoque.manutencao.EstoqueManutencao;

public interface IManutencao {
	
	public Serializable criarEstoqueManutencao(EstoqueManutencao estoqueManutencao);
	public EstoqueManutencao encontrarEstoqueManutencao(Long idEstoqueManutencao);

}

package main.java.interfaces.consertomanutencao;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.cobrado.CobradoManutencao;
import main.java.modelo.estoque.manutencao.EstoqueManutencao;

public interface IManutencao {
	
	public Serializable criarCobradoManutencao(CobradoManutencao itemCobradoManutencao);
	public CobradoManutencao encontrarCobradoManutencao(Long idItemCobradoManutencao);
	public List<EstoqueManutencao> encotrarTodosEstoqueManutencao();
	public Boolean atualizarEstoqueManutencao(EstoqueManutencao estoqueManutencao);
	public Boolean deletarEstoqueManutencao(EstoqueManutencao estoqueManutencao);

}

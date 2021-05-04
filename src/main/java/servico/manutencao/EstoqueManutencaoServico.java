package main.java.servico.manutencao;

import java.io.Serializable;

import main.java.dao.manutencao.EstoqueManutencaoDAO;
import main.java.modelo.estoque.manutencao.EstoqueManutencao;

public class EstoqueManutencaoServico {
	
	private EstoqueManutencaoDAO estoqueManutencaoDAO = new EstoqueManutencaoDAO();

	public Serializable criarEstoqueManutencao(EstoqueManutencao estoqueManutencao) {
		if (estoqueManutencao  != null) {
			return estoqueManutencaoDAO.criarEstoqueManutencao(estoqueManutencao);
		}
		return null;
	}

	public EstoqueManutencao encontrarEstoqueManutencao(Long idEstoqueManutencao) {
		if (idEstoqueManutencao != null) {
			return estoqueManutencaoDAO.encontrarEstoqueManutencao(idEstoqueManutencao);
		}
		return null;
	}

	public Boolean deletarEstoqueManutencao(EstoqueManutencao estoqueManutencao) {
		return estoqueManutencaoDAO.deletarEstoqueManutencao(estoqueManutencao);
	}

}

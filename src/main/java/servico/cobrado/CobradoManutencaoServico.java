package main.java.servico.cobrado;

import java.io.Serializable;
import java.util.List;

import main.java.dao.cobrado.CobradoManutencaoDAO;
import main.java.modelo.cobrado.CobradoManutencao;
import main.java.modelo.estoque.manutencao.EstoqueManutencao;

public class CobradoManutencaoServico {
	
	private CobradoManutencaoDAO cobradoManutencaoDAO = new CobradoManutencaoDAO();

	public Serializable criarCobradoManutencao(CobradoManutencao itemCobradoManutencao) {
		if (!itemCobradoManutencao.equals(null)) {
			return cobradoManutencaoDAO.criarCobradoManutencao(itemCobradoManutencao);
		}
		return null;
	}

	public CobradoManutencao encontrarCobradoManutencao(Long idItemCobradoManutencao) {
		if (!idItemCobradoManutencao.equals(null)) {
			return cobradoManutencaoDAO.encontrarCobradoManutencao(idItemCobradoManutencao);
		}
		return null;
	}

	public List<EstoqueManutencao> encotrarTodosEstoqueManutencao() {
		return cobradoManutencaoDAO.encotrarTodosEstoqueManutencao();
	}

	public Boolean atualizarEstoqueManutencao(EstoqueManutencao estoqueManutencao) {
		return cobradoManutencaoDAO.atualizarEstoqueManutencao(estoqueManutencao);
	}

	public Boolean deletarEstoqueManutencao(EstoqueManutencao estoqueManutencao) {
		return cobradoManutencaoDAO.deletarEstoqueManutencao(estoqueManutencao);
	}

}

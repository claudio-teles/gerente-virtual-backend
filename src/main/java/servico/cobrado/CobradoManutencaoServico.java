package main.java.servico.cobrado;

import java.io.Serializable;

import main.java.dao.cobrado.CobradoManutencaoDAO;
import main.java.modelo.cobrado.CobradoManutencao;

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

	public Boolean atualizarEstoqueManutencao(CobradoManutencao cobradoManutencao) {
		return cobradoManutencaoDAO.atualizarEstoqueManutencao(cobradoManutencao);
	}

	public Boolean deletarEstoqueManutencao(CobradoManutencao cobradoManutencao) {
		return cobradoManutencaoDAO.deletarEstoqueManutencao(cobradoManutencao);
	}

}

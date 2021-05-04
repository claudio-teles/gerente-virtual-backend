package main.java.servico.fornecedor;

import java.io.Serializable;
import java.util.List;

import main.java.dao.fornecedor.FornecedorDAO;
import main.java.modelo.fornecedor.Fornecedor;

public class FornecedorServico {
	
	private FornecedorDAO fornecedorDAO = new FornecedorDAO();

	public Serializable criarFornecedor(Fornecedor fornecedor) {
		if (fornecedor != null) {
			return fornecedorDAO.criarFornecedor(fornecedor);
		}
		return null;
	}

	public Fornecedor encontrarFornecedor(Long idFornecedor) {
		if (idFornecedor != null) {
			return fornecedorDAO.encontrarFornecedor(idFornecedor);
		}
		return null;
	}

	public List<Fornecedor> encontrarFornecedores() {
		return fornecedorDAO.encontrarFornecedores();
	}

	public Boolean atualizarFornecedor(Fornecedor fornecedor) {
		return fornecedorDAO.atualizarFornecedor(fornecedor);
	}

	public Boolean deletararFornecedor(Fornecedor fornecedor) {
		return fornecedorDAO.deletararFornecedor(fornecedor);
	}

}

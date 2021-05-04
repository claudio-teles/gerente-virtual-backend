package main.java.servico.endereco;

import java.io.Serializable;
import java.util.List;

import main.java.dao.endereco.EnderecoDAO;
import main.java.modelo.endereco.Endereco;

public class EnderecoServico {
	
	private EnderecoDAO enderecoDAO = new EnderecoDAO();

	public Serializable criarEndereco(Endereco endereco) {
		if (endereco != null) {
			return enderecoDAO.criarEndereco(endereco);
		}
		return null;
	}

	public Endereco encontrarEndereco(Long idEndereco) {
		if (idEndereco != null) {
			return enderecoDAO.encontrarEndereco(idEndereco);
		}
		return null;
	}

	public List<Endereco> encontrarEndereco(String cep) {
		return enderecoDAO.encontrarEndereco(cep);
	}

	public List<Endereco> encontrarEnderecos() {
		return enderecoDAO.encontrarEnderecos();
	}

	public Boolean atualizarEndereco(Endereco endereco) {
		return enderecoDAO.atualizarEndereco(endereco);
	}

	public Boolean deletarEndereco(Endereco endereco) {
		return enderecoDAO.deletarEndereco(endereco);
	}

}

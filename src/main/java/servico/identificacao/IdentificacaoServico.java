package main.java.servico.identificacao;

import java.io.Serializable;
import java.util.List;

import main.java.dao.identificacao.IdentificacaoDAO;
import main.java.modelo.identificacao.Identificacao;

public class IdentificacaoServico {
	
	private IdentificacaoDAO identificacaoDAO = new IdentificacaoDAO();

	public Serializable criarIdentificacao(Identificacao identificacao) {
		if (identificacao != null) {
			return identificacaoDAO.criarIdentificacao(identificacao);
		}
		return null;
	}

	public Identificacao encontrarIdentificacao(Long idIdentificacao) {
		if (idIdentificacao != null) {
			return identificacaoDAO.encontrarIdentificacao(idIdentificacao);
		}
		return null;
	}

	public Identificacao encontrarIdentificacaoCnpj(String cnpj) {
		if ( !(cnpj.equals("") && cnpj.equals(null)) ) {
			return identificacaoDAO.encontrarIdentificacaoCnpj(cnpj);
		}
		return null;
	}

	public Identificacao encontrarIdentificacaoCpf(String cpf) {
		if ( !(cpf.equals("") && cpf.equals(null)) ) {
			return identificacaoDAO.encontrarIdentificacaoCpf(cpf);
		}
		return null;
	}

	public List<Identificacao> encontrarTodasIdentificacao() {
		return identificacaoDAO.encontrarTodasIdentificacao();
	}

	public Boolean atualizarIdentificacao(Identificacao identificacao) {
		return identificacaoDAO.atualizarIdentificacao(identificacao);
	}

	public Boolean deletarIdentificacao(Identificacao identificacao) {
		return identificacaoDAO.deletarIdentificacao(identificacao);
	}

}

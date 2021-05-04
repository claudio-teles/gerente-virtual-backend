package main.java.servico.financa.contareceber;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.dao.financa.contareceber.ContaReceberDAO;
import main.java.modelo.financa.contareceber.ContaReceber;

public class ContaReceberServico {
	
	private ContaReceberDAO contaReceberDAO = new ContaReceberDAO();

	public Serializable criarContaReceber(ContaReceber contaReceber) {
		if (contaReceber != null) {
			return contaReceberDAO.criarContaReceber(contaReceber);
		}
		return null;
	}

	public ContaReceber encontrarContaReceber(Long idContaReceber) {
		if (idContaReceber != null) {
			return contaReceberDAO.encontrarContaReceber(idContaReceber);
		}
		return null;
	}

	public ContaReceber encontrarContaReceberIdVenda(Long idVenda) {
		if (idVenda != null) {
			return contaReceberDAO.encontrarContaReceberIdVenda(idVenda);
		}
		return null;
	}

	public List<ContaReceber> encontrarContasReceber() {
		return contaReceberDAO.encontrarContasReceber();
	}

	public List<ContaReceber> encontrarContasReceber(Calendar dataRecebimento) {
		if (dataRecebimento != null) {
			return contaReceberDAO.encontrarContasReceber(dataRecebimento);
		}
		return null;
	}

	public Boolean atualizarContasReceber(ContaReceber contaReceber) {
		return contaReceberDAO.atualizarContasReceber(contaReceber);
	}

	public Boolean deletarContasReceber(ContaReceber contaReceber) {
		return contaReceberDAO.deletarContasReceber(contaReceber);
	}

}

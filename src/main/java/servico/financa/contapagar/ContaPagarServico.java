package main.java.servico.financa.contapagar;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.dao.financa.contapagar.ContaPagarDAO;
import main.java.modelo.financa.contapagar.ContaPagar;

public class ContaPagarServico {
	
	private ContaPagarDAO contaPagarDao = new ContaPagarDAO();

	public Serializable criarContaPagar(ContaPagar contaPagar) {
		if (contaPagar != null) {
			return contaPagarDao.criarContaPagar(contaPagar);
		}
		return null;
	}

	public ContaPagar encontarContaPagar(Long idContaPagar) {
		if (idContaPagar != null) {
			return contaPagarDao.encontarContaPagar(idContaPagar);
		}
		return null;
	}

	public ContaPagar encontarContaPagarIdCompra(Long idCompra) {
		if (idCompra != null) {
			return contaPagarDao.encontarContaPagarIdCompra(idCompra);
		}
		return null;
	}

	public List<ContaPagar> encontrarTodasContasPagar() {
		return contaPagarDao.encontrarTodasContasPagar();
	}

	public List<ContaPagar> encontrarTodasContasPagar(Calendar dataPagamento) {
		return contaPagarDao.encontrarTodasContasPagar(dataPagamento);
	}

	public Boolean atualizarContaPagar(ContaPagar contaPagar) {
		return contaPagarDao.atualizarContaPagar(contaPagar);
	}

	public Boolean deletarContaPagar(ContaPagar contaPagar) {
		return contaPagarDao.deletarContaPagar(contaPagar);
	}

}

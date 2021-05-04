package main.java.servico.financa.saida;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.dao.financa.saida.SaidaDinheiroDAO;
import main.java.modelo.financa.saidadinheiro.SaidaDinheiro;

public class SaidaDinheiroServico {
	
	private SaidaDinheiroDAO saidaDinheiroDao = new SaidaDinheiroDAO();

	public Serializable criarSaidaDinheiro(SaidaDinheiro saidaDinheiro) {
		if (saidaDinheiro != null) {
			return saidaDinheiroDao.criarSaidaDinheiro(saidaDinheiro);
		}
		return null;
	}

	public SaidaDinheiro encontrarSaidaDinheiro(Long idSaidaDinheiro) {
		if (idSaidaDinheiro != null) {
			return saidaDinheiroDao.encontrarSaidaDinheiro(idSaidaDinheiro);
		}
		return null;
	}

	public List<SaidaDinheiro> encontrarTodasSaidas(Calendar dataInicial, Calendar dataFinal) {
		if (dataInicial != null && dataFinal != null) {
			return saidaDinheiroDao.encontrarTodasSaidas(dataInicial, dataFinal);
		}
		return null;
	}

	public List<SaidaDinheiro> encontrarTodasSaidasPaginacao(Integer inicio, Integer maximo) {
		if (inicio != null && maximo != null) {
			return saidaDinheiroDao.encontrarTodasSaidasPaginacao(inicio, maximo);
		}
		return null;
	}

	public Boolean atualizar(SaidaDinheiro saidaDinheiro) {
		return saidaDinheiroDao.atualizar(saidaDinheiro);
	}

	public Boolean deletar(SaidaDinheiro saidaDinheiro) {
		return saidaDinheiroDao.deletar(saidaDinheiro);
	}

}

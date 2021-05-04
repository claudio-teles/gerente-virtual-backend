package main.java.servico.financa.entrada;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.dao.financa.entrada.EntradaDinherioDAO;
import main.java.modelo.financa.entrada.EntradaDinheiro;

public class EntradaDinheiroServico {
	
	private EntradaDinherioDAO entradaDinherioDAO = new EntradaDinherioDAO();

	public Serializable criarEntradaDinheiro(EntradaDinheiro entradaDinheiro) {
		if (entradaDinheiro != null) {
			return entradaDinherioDAO.criarEntradaDinheiro(entradaDinheiro);
		}
		return null;
	}

	public EntradaDinheiro encontrarEntradaDinheiro(Long idEntradaDinheiro) {
		if(idEntradaDinheiro != null) {return entradaDinherioDAO.encontrarEntradaDinheiro(idEntradaDinheiro);} else {return null;}
	}

	public List<EntradaDinheiro> encontrarTodasEntradasDinheiroPaginacao(Integer inicio, Integer maximo) {
		if (inicio != null && maximo != null) {
			return entradaDinherioDAO.encontrarTodasEntradasDinheiroPaginacao(inicio, maximo);
		}
		return null;
	}

	public List<EntradaDinheiro> encontrarTodasEntradasDinheiro(Calendar dataInicial, Calendar dataFinal) {
		if (dataInicial != null && dataFinal != null) {
			return entradaDinherioDAO.encontrarTodasEntradasDinheiro(dataInicial, dataFinal);
		}
		return null;
	}

	public Boolean atualizarEntradaDinheiro(EntradaDinheiro entradaDinheiro) {
		return entradaDinherioDAO.atualizarEntradaDinheiro(entradaDinheiro);
	}

	public Boolean deletarEntradaDinheiro(EntradaDinheiro entradaDinheiro) {
		return entradaDinherioDAO.deletarEntradaDinheiro(entradaDinheiro);
	}


}

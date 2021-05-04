package main.java.servico.peca;

import java.io.Serializable;
import java.util.List;

import main.java.dao.peca.PecaDAO;
import main.java.modelo.peca.Peca;

public class PecaServico {
	
	private PecaDAO pecaDao = new PecaDAO();

	public Serializable criarPeca(Peca peca) {
		if (peca != null) {
			return pecaDao.criarPeca(peca);
		}
		return null;
	}

	public Peca encontrarPeca(Long idPeca) {
		if (idPeca != null) {
			return pecaDao.encontrarPeca(idPeca);
		}
		return null;
	}

	public Peca encontrarPecaCodigo(String codigoPeca) {
		if ( !(codigoPeca.equals("") || codigoPeca.equals(null)) ) {
			return pecaDao.encontrarPecaCodigo(codigoPeca);
		}
		return null;
	}

	public List<Peca> encontrarPecasDescricao(String descricao) {
		if ( !(descricao.equals("") || descricao.equals(null)) ) {
			return pecaDao.encontrarPecasDescricao(descricao);
		}
		return null;
	}

	public List<Peca> encontrarPecasFabricante(String fabricante) {
		if ( !(fabricante.equals("") || fabricante.equals(null)) ) {
			return pecaDao.encontrarPecasFabricante(fabricante);
		}
		return null;
	}

	public List<Peca> encontrarPecasLocal(String localEstaGuardado) {
		if ( !(localEstaGuardado.equals("") || localEstaGuardado.equals(null)) ) {
			return pecaDao.encontrarPecasLocal(localEstaGuardado);
		}
		return null;
	}

	public List<Peca> encontrarPecasNome(String nomeDaPeca) {
		if ( !(nomeDaPeca.equals("") || nomeDaPeca.equals(null)) ) {
			return pecaDao.encontrarPecasNome(nomeDaPeca);
		}
		return null;
	}

	public List<Peca> encontrarPecas() {
		return pecaDao.encontrarPecas();
	}

	public List<Peca> encontrarPecasPaginacao(Integer inicio, Integer maximo) {
		if ( !(inicio.equals(null) || maximo.equals(null)) ) {
			return pecaDao.encontrarPecasPaginacao(inicio, maximo);
		}
		return null;
	}

	public Boolean atualizarPeca(Peca peca) {
		return pecaDao.atualizarPeca(peca);
	}

	public Boolean deletarPeca(Peca peca) {
		return pecaDao.deletarPeca(peca);
	}

}

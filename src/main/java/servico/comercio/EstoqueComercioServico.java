package main.java.servico.comercio;

import java.io.Serializable;
import java.util.Set;

import main.java.dao.comercio.EstoqueComercioDAO;
import main.java.modelo.estoque.comercio.EstoqueComercio;
import main.java.modelo.mercadoria.Mercadoria;

public class EstoqueComercioServico {
	
	private EstoqueComercioDAO estoqueComercioDAO = new EstoqueComercioDAO();

	public Serializable criarEstoqueMercadoriaComercio(EstoqueComercio estoqueComercio) {
		if (estoqueComercio != null) {
			return estoqueComercioDAO.criarEstoqueMercadoriaComercio(estoqueComercio);
		}
		return null;
	}

	public EstoqueComercio encontrarMercadoriaEstoque(Long idMercadoriaEstoqueComercio) {
		if (idMercadoriaEstoqueComercio != null) {
			return estoqueComercioDAO.encontrarMercadoriaEstoque(idMercadoriaEstoqueComercio);
		}
		return null;
	}

	public Set<Mercadoria> encontrarTodasMercadoriaEstoque(Long idMercadoriaEstoqueComercio) {
		if (idMercadoriaEstoqueComercio != null) {
			return estoqueComercioDAO.encontrarTodasMercadoriaEstoque(idMercadoriaEstoqueComercio);
		}
		return null;
	}

	public Boolean deletarEstoqueMercadoria(EstoqueComercio estoqueComercio) {
		return estoqueComercioDAO.deletarEstoqueMercadoria(estoqueComercio);
	}

}

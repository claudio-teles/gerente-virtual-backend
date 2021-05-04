package main.java.servico.mercadoria;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import main.java.dao.mercadoria.MercadoriaDAO;
import main.java.modelo.mercadoria.Mercadoria;

public class MercadoriaServico {
	
	private MercadoriaDAO mercadoriaDAO = new MercadoriaDAO();

	public Serializable criarMercadoria(Mercadoria mercadoria) {
		if (mercadoria != null) {
			return mercadoriaDAO.criarMercadoria(mercadoria);
		}
		return null;
	}

	public Mercadoria encontrarMercadoria(Long idMercadoria) {
		if (idMercadoria != null) {
			return mercadoriaDAO.encontrarMercadoria(idMercadoria);
		}
		return null;
	}

	public Set<Mercadoria> encontrarTodasMercadorias() {
		return mercadoriaDAO.encontrarTodasMercadorias();
	}

	public String atualizarMercadoria(Mercadoria mercadoria) {
		return mercadoriaDAO.atualizarMercadoria(mercadoria);
	}

	public Mercadoria encontrarMercadoriaCodBarra(String codigoBarraMercadoria) {
		if ( !(codigoBarraMercadoria.equals("") && codigoBarraMercadoria.equals(null)) ) {
			return mercadoriaDAO.encontrarMercadoriaCodBarra(codigoBarraMercadoria);
		}
		return null;
	}

	public List<Mercadoria> listarMercadoriasDataAquisicao(Calendar dataAquisicaoMercadoria) {
		if ( !(dataAquisicaoMercadoria.equals(null)) ) {
			return mercadoriaDAO.listarMercadoriasDataAquisicao(dataAquisicaoMercadoria);
		}
		return null;
	}

	public List<Mercadoria> listarMercadoriasDataVencimento(Calendar dataVencimentoMercadoria) {
		if ( !(dataVencimentoMercadoria.equals(null)) ) {
			return mercadoriaDAO.listarMercadoriasDataVencimento(dataVencimentoMercadoria);
		}
		return null;
	}

	public List<Mercadoria> listarMercadorias() {
		return mercadoriaDAO.listarMercadorias();
	}

	public Boolean deletarMercadoria(Mercadoria mercadoria) {
		return mercadoriaDAO.deletarMercadoria(mercadoria);
	}

}

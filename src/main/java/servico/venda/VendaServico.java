package main.java.servico.venda;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.dao.venda.VendaDAO;
import main.java.modelo.venda.Venda;

public class VendaServico {
	
	private VendaDAO vendaDAO = new VendaDAO();

	public Serializable criarVenda(Venda venda) {
		if (venda != null) {
			return vendaDAO.criarVenda(venda);
		}
		return null;
	}

	public Venda encontrarVenda(Long idVenda) {
		if (idVenda != null) {
			return vendaDAO.encontrarVenda(idVenda);
		}
		return null;
	}

	public List<Venda> encontrarVendas() {
		return vendaDAO.encontrarVendas();
	}

	public List<Venda> encontrarVendas(Calendar dataVenda) {
		if (dataVenda != null) {
			return vendaDAO.encontrarVendas(dataVenda);
		}
		return null;
	}

	public List<Venda> encontrarVendasPaginacao(Integer inicio, Integer maximo) {
		if ( !(inicio.equals(null) && maximo.equals(null)) ) {
			return vendaDAO.encontrarVendasPaginacao(inicio, maximo);
		}
		return null;
	}

	public Boolean atualizar(Venda venda) {
		return vendaDAO.atualizar(venda);
	}

	public Boolean deletar(Venda venda) {
		return vendaDAO.deletar(venda);
	}

}

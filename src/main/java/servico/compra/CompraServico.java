package main.java.servico.compra;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.dao.compra.CompraDAO;
import main.java.modelo.compra.Compra;

public class CompraServico {
	
	private CompraDAO compraDAO = new CompraDAO();

	public Serializable criarCompra(Compra compra) {
		if (compra != null) {
			return compraDAO.criarCompra(compra);
		}
		return null;
	}

	public Compra encontrarCompra(Long idCompra) {
		if (idCompra != null) {
			return compraDAO.encontrarCompra(idCompra);
		}
		return null;
	}

	public List<Compra> listarTodasCompras() {
		return compraDAO.listarTodasCompras();
	}

	public List<Compra> listarTodasCompras(Calendar dataCompra) {
		if (dataCompra != null) {
			return compraDAO.listarTodasCompras(dataCompra);
		}
		return null;
	}

	public Boolean atualizarCompra(Compra compra) {
		return compraDAO.atualizarCompra(compra);
	}

	public Boolean deletarCompra(Compra compra) {
		return compraDAO.deletarCompra(compra);
	}

}

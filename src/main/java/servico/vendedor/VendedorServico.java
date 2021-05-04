package main.java.servico.vendedor;

import java.io.Serializable;
import java.util.List;

import main.java.dao.vendedor.VendedorDAO;
import main.java.modelo.vendedor.Vendedor;

public class VendedorServico {
	
	private VendedorDAO vendedorDAO = new VendedorDAO();

	public Serializable criarVendedor(Vendedor vendedor) {
		if (vendedor != null) {
			return vendedorDAO.criarVendedor(vendedor);
		}
		return null;
	}

	public Vendedor encontrarVendedor(Long idVendedor) {
		if (idVendedor != null) {
			return vendedorDAO.encontrarVendedor(idVendedor);
		}
		return null;
	}

	public List<Vendedor> encontrarVendedores() {
		return vendedorDAO.encontrarVendedores();
	}

	public Boolean atualizar(Vendedor vendedor) {
		return vendedorDAO.atualizar(vendedor);
	}

	public Boolean deletar(Vendedor vendedor) {
		return vendedorDAO.deletar(vendedor);
	}

}

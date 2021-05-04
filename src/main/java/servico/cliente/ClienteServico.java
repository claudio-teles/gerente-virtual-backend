package main.java.servico.cliente;

import java.io.Serializable;
import java.util.List;

import main.java.dao.cliente.ClienteDAO;
import main.java.modelo.cliente.Cliente;

public class ClienteServico {
	
	private ClienteDAO clienteDAO = new ClienteDAO();

	public Serializable criarCliente(Cliente cliente) {
		if (cliente != null) {
			return clienteDAO.criarCliente(cliente);
		}
		return null;
	}

	public Cliente encontrarCliente(Long idCliente) {
		if (!idCliente.equals(null)) {
			return clienteDAO.encontrarCliente(idCliente);
		}
		return null;
	}
	
	public Cliente encontrarCliente(Integer idade) {
		if (!idade.equals(null)) {
			return clienteDAO.encontrarCliente(idade);
		}
		return null;
	}

	public List<Cliente> encontrarClientesEntre(Integer idade1, Integer idade2) {
		if ( !(idade1.equals(null) && idade2.equals(null))  ) {
			return clienteDAO.encontrarClientesEntre(idade1, idade2);
		}
		return null;
	}

	public Boolean atualizar(Cliente cliente) {
		return clienteDAO.atualizar(cliente);
	}

	public Boolean deletar(Cliente cliente) {
		return clienteDAO.deletar(cliente);
	}
}

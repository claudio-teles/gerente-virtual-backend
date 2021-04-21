package main.java.servico.cliente;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.cliente.ICliente;
import main.java.modelo.cliente.Cliente;
import main.java.sessao.Sessao;

public class ClienteServico implements ICliente {

	@Override
	public Serializable criarCliente(Cliente cliente) {
		Session scc = Sessao.getSessionFactory().openSession();
		scc.beginTransaction();
		
		Serializable sC = scc.save(cliente);
		
		scc.getTransaction().commit();
		scc.close();
		return sC;
	}

	@Override
	public Cliente encontrarCliente(Long idCliente) {
		Session sc = Sessao.getSessionFactory().openSession();
		sc.beginTransaction();
		
		Cliente cliente = sc.find(Cliente.class, idCliente);
		
		sc.getTransaction().commit();
		sc.close();
		return cliente;
	}

}

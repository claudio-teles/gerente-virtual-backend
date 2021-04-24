package main.java.servico.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.java.interfaces.cliente.ICliente;
import main.java.modelo.cliente.Cliente;
import main.java.modelo.contato.Contato;
import main.java.modelo.endereco.Endereco;
import main.java.modelo.identificacao.Identificacao;
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

	@Override
	public Identificacao encontrarIdentificacao(Long idCliente) {
		return encontrarCliente(idCliente).getIdentificacao();
	}

	@Override
	public Endereco encontrarEndereco(Long idCliente) {
		return encontrarCliente(idCliente).getEndereco();
	}

	@Override
	public Contato encontrarContato(Long idCliente) {
		return encontrarCliente(idCliente).getContato();
	}
	
	@Override
	public Cliente encontrarCliente(Integer idade) {
		Session sencontrarCliente = Sessao.getSessionFactory().openSession();
		sencontrarCliente.beginTransaction();
		
		Query queryCliente = sencontrarCliente.createQuery("FROM Cliente WHERE idade = :idade");
		queryCliente.setParameter("idade", idade);
		
		Cliente cliente = new Cliente();
		cliente = (Cliente) queryCliente.getSingleResult();
		
		sencontrarCliente.getTransaction().commit();
		sencontrarCliente.close();
		return cliente;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> encontrarClientesEntre(Integer idade1, Integer idade2) {
		Session sencontrarClientes = Sessao.getSessionFactory().openSession();
		sencontrarClientes.beginTransaction();
		
		Query queryClientes = sencontrarClientes.createQuery("FROM Cliente WHERE idade >= :idade1 and idade <= :idade2");
		queryClientes.setParameter("idade1", idade1);
		queryClientes.setParameter("idade2", idade2);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes = queryClientes.getResultList();
		
		sencontrarClientes.getTransaction().commit();
		sencontrarClientes.close();
		return clientes;
	}

}

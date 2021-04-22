package main.java.servico.compra;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.compra.ICompra;
import main.java.modelo.compra.Compra;
import main.java.sessao.Sessao;

public class CompraServico implements ICompra {

	@Override
	public Serializable criarCompra(Compra compra) {
		Session scc = Sessao.getSessionFactory().openSession();
		scc.beginTransaction();
		
		Serializable sC = scc.save(compra);
		
		scc.getTransaction().commit();
		scc.close();
		return sC;
	}

	@Override
	public Compra encontrarCompra(Long idCompra) {
		Session sec = Sessao.getSessionFactory().openSession();
		sec.beginTransaction();
		
		Compra compra = sec.find(Compra.class, idCompra);
		
		sec.getTransaction().commit();
		sec.close();
		return compra;
	}

}

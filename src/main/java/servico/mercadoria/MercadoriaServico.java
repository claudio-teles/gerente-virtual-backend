package main.java.servico.mercadoria;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.mercadoria.IMercadoria;
import main.java.modelo.mercadoria.Mercadoria;
import main.java.sessao.Sessao;

public class MercadoriaServico implements IMercadoria {

	@Override
	public Serializable criarMercadoria(Mercadoria mercadoria) {
		Session sessionMercadoria = Sessao.getSessionFactory().openSession();
		sessionMercadoria.beginTransaction();
		
		Serializable sm = sessionMercadoria.save(mercadoria);
		
		sessionMercadoria.getTransaction().commit();
		sessionMercadoria.close();
		return sm;
	}

	@Override
	public Mercadoria encontrarMercadoria(Long idMercadoria) {
		Session sM = Sessao.getSessionFactory().openSession();
		sM.beginTransaction();
		
		Mercadoria mercadoria = sM.find(Mercadoria.class, idMercadoria);
		
		sM.getTransaction().commit();
		sM.close();
		return mercadoria;
	}

}

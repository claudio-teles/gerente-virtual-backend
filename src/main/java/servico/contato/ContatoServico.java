package main.java.servico.contato;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.contato.IContato;
import main.java.modelo.contato.Contato;
import main.java.sessao.Sessao;

public class ContatoServico implements IContato {

	@Override
	public Serializable criarContato(Contato contato) {
		Session sCont = Sessao.getSessionFactory().openSession();
		sCont.beginTransaction();
		
		Serializable sc = sCont.save(contato);
		
		sCont.getTransaction().commit();
		sCont.close();
		return sc;
	}

	@Override
	public Contato encotrarContato(Long idContato) {
		Session sC = Sessao.getSessionFactory().openSession();
		sC.beginTransaction();
		
		Contato contato = sC.find(Contato.class, idContato);
		
		sC.getTransaction().commit();
		sC.close();
		return contato;
	}

}

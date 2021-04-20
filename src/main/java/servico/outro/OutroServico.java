package main.java.servico.outro;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.outro.IOutro;
import main.java.modelo.outro.Outro;
import main.java.sessao.Sessao;

public class OutroServico implements IOutro {

	@Override
	public Serializable criarOutro(Outro outro) {
		Session sco = Sessao.getSessionFactory().openSession();
		sco.beginTransaction();
		
		Serializable sO = sco.save(outro);
		
		sco.getTransaction().commit();
		sco.close();
		return sO;
	}

	@Override
	public Outro encontrarOutro(Long idOutro) {
		Session so = Sessao.getSessionFactory().openSession();
		so.beginTransaction();
		
		Outro outro = so.find(Outro.class, idOutro);
		
		so.getTransaction().commit();
		so.close();
		return outro;
	}

}

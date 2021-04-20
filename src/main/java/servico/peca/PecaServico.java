package main.java.servico.peca;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.peca.IPeca;
import main.java.modelo.peca.Peca;
import main.java.sessao.Sessao;

public class PecaServico implements IPeca {

	@Override
	public Serializable criarPeca(Peca peca) {
		Session scp = Sessao.getSessionFactory().openSession();
		scp.beginTransaction();
		
		Serializable sp = scp.save(peca);
		
		scp.getTransaction().commit();
		scp.close();
		return sp;
	}

	@Override
	public Peca encontrarPeca(Long idPeca) {
		Session sP = Sessao.getSessionFactory().openSession();
		sP.beginTransaction();
		
		Peca peca = sP.find(Peca.class, idPeca);
		
		sP.getTransaction().commit();
		sP.close();
		return peca;
	}

}

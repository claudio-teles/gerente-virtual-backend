package main.java.servico.identificacao;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.config.I_Identificacao;
import main.java.modelo.identificacao.Identificacao;
import main.java.sessao.Sessao;

public class IdentificacaoServico implements I_Identificacao {

	@Override
	public Serializable criarIdentificacao(Identificacao identificacao) {
		Session sIdent = Sessao.getSessionFactory().openSession();
		sIdent.beginTransaction();
		
		Serializable si = sIdent.save(identificacao);
		
		sIdent.getTransaction().commit();
		sIdent.close();
		return si;
	}

	@Override
	public Identificacao encontrarIdentificacao(Long idIdentificacao) {
		Session sI = Sessao.getSessionFactory().openSession();
		sI.beginTransaction();
		
		Identificacao identificacao = sI.find(Identificacao.class, idIdentificacao);
		
		sI.getTransaction().commit();
		sI.close();
		return identificacao;
	}

}

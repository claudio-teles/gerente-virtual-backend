package main.java.dao.identificacao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.java.interfaces.config.I_Identificacao;
import main.java.modelo.identificacao.Identificacao;
import main.java.sessao.Sessao;

public class IdentificacaoDAO implements I_Identificacao {

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

	@Override
	public Identificacao encontrarIdentificacaoCnpj(String cnpj) {
		Session sid = Sessao.getSessionFactory().openSession();
		sid.beginTransaction();
		Query queryLsid = sid.createQuery("FROM Identificacao WHERE cnpj = :cnpj");
		queryLsid.setParameter("cnpj", cnpj);
		
		Identificacao identificacao = (Identificacao) queryLsid.getSingleResult();
		
		sid.getTransaction().commit();
		sid.close();
		return identificacao;
	}

	@Override
	public Identificacao encontrarIdentificacaoCpf(String cpf) {
		Session sid = Sessao.getSessionFactory().openSession();
		sid.beginTransaction();
		Query queryLsid = sid.createQuery("FROM Identificacao WHERE cpf = :cpf");
		queryLsid.setParameter("cpf", cpf);
		
		Identificacao identificacao = (Identificacao) queryLsid.getSingleResult();
		
		sid.getTransaction().commit();
		sid.close();
		return identificacao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Identificacao> encontrarTodasIdentificacao() {
		Session sid = Sessao.getSessionFactory().openSession();
		sid.beginTransaction();
		
		Query queryLsid = sid.createQuery("FROM Identificacao ORDER BY idIdentificacao ASC");
		List<Identificacao> identificacoes = queryLsid.getResultList();
		
		sid.getTransaction().commit();
		sid.close();
		return identificacoes;
	}

	@Override
	public Boolean atualizarIdentificacao(Identificacao identificacao) {
		if (identificacao.getIdIdentificacao() != null) {
			Session sI = Sessao.getSessionFactory().openSession();
			sI.beginTransaction();
			
			sI.saveOrUpdate(identificacao);
			
			sI.getTransaction().commit();
			sI.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarIdentificacao(Identificacao identificacao) {
		if (identificacao.getIdIdentificacao() != null) {
			Session sI = Sessao.getSessionFactory().openSession();
			sI.beginTransaction();
			
			sI.delete(identificacao);
			
			sI.getTransaction().commit();
			sI.close();
			return true;
		}
		return false;
	}

}

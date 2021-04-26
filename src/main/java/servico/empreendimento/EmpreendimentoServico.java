package main.java.servico.empreendimento;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.java.interfaces.empreendimento.IEmpreendimento;
import main.java.modelo.empreendimento.Empreendimento;
import main.java.sessao.Sessao;

public class EmpreendimentoServico implements IEmpreendimento {

	@Override
	public Serializable criarEmpreendimento(Empreendimento empreendimento) {
		Session sessaoCriarEmpreendimento = Sessao.getSessionFactory().openSession();
		sessaoCriarEmpreendimento.beginTransaction();
		
		Serializable sce = sessaoCriarEmpreendimento.save(empreendimento);
		
		sessaoCriarEmpreendimento.getTransaction().commit();
		sessaoCriarEmpreendimento.close();
		return sce;
	}

	@Override
	public Empreendimento encontrarEmpreendimento(Long idEmpreendimento) {
		Session sessaoEncontrarEmpreendimento = Sessao.getSessionFactory().openSession();
		sessaoEncontrarEmpreendimento.beginTransaction();
		
		Empreendimento empreendimento = sessaoEncontrarEmpreendimento.find(Empreendimento.class, idEmpreendimento);
		
		sessaoEncontrarEmpreendimento.getTransaction().commit();
		sessaoEncontrarEmpreendimento.close();
		return empreendimento;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empreendimento> encontrarEmpreendimentos() {
		Session see = Sessao.getSessionFactory().openSession();
		see.beginTransaction();
		
		Query queryLsee = see.createQuery("FROM Empreendimento ORDER BY idEmpreendimento ASC");
		List<Empreendimento> empreendimentos = queryLsee.getResultList();
		
		see.getTransaction().commit();
		see.close();
		return empreendimentos;
	}

	@Override
	public Boolean atualizarEmpreendimento(Empreendimento empreendimento) {
		if (empreendimento.getIdEmpreendimento() != null) {
			Session sessaoAtualizarEmpreendimento = Sessao.getSessionFactory().openSession();
			sessaoAtualizarEmpreendimento.beginTransaction();
			
			sessaoAtualizarEmpreendimento.saveOrUpdate(empreendimento);
			
			sessaoAtualizarEmpreendimento.getTransaction().commit();
			sessaoAtualizarEmpreendimento.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarEmpreendimento(Empreendimento empreendimento) {
		if (empreendimento.getIdEmpreendimento() != null) {
			Session sessaoDeletarEmpreendimento = Sessao.getSessionFactory().openSession();
			sessaoDeletarEmpreendimento.beginTransaction();
			
			sessaoDeletarEmpreendimento.delete(empreendimento);
			
			sessaoDeletarEmpreendimento.getTransaction().commit();
			sessaoDeletarEmpreendimento.close();
			return true;
		}
		return false;
	}

}

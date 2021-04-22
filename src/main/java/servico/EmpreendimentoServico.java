package main.java.servico;

import java.io.Serializable;

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

}

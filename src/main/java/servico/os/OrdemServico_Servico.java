package main.java.servico.os;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.os.IOrdemServico;
import main.java.modelo.ordemservico.OrdemServico;
import main.java.sessao.Sessao;

public class OrdemServico_Servico implements IOrdemServico {

	@Override
	public Serializable criarOrdemServico(OrdemServico ordemServico) {
		Session sessaoCriarOS = Sessao.getSessionFactory().openSession();
		sessaoCriarOS.beginTransaction();
		
		Serializable scos = sessaoCriarOS.save(ordemServico);
		
		sessaoCriarOS.getTransaction().commit();
		sessaoCriarOS.close();
		return scos;
	}

	@Override
	public OrdemServico encontrarOrdemServico(Long idOrdemServico) {
		Session sessaoEncontrarOS = Sessao.getSessionFactory().openSession();
		sessaoEncontrarOS.beginTransaction();
		
		OrdemServico ordemServico = sessaoEncontrarOS.find(OrdemServico.class, idOrdemServico);
		
		sessaoEncontrarOS.getTransaction().commit();
		sessaoEncontrarOS.close();
		return ordemServico;
	}

}

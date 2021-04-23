package main.java.servico.financa.contapagar;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.financa.contapagar.IContaPagar;
import main.java.modelo.financa.contapagar.ContaPagar;
import main.java.sessao.Sessao;

public class ContaPagarServico implements IContaPagar {

	@Override
	public Serializable criarContaPagar(ContaPagar contaPagar) {
		Session sCp = Sessao.getSessionFactory().openSession();
		sCp.beginTransaction();
		
		Serializable sc = sCp.save(contaPagar);
		
		sCp.getTransaction().commit();
		sCp.close();
		return sc;
	}

	@Override
	public ContaPagar encontarContaPagar(Long idContaPagar) {
		Session scp = Sessao.getSessionFactory().openSession();
		scp.beginTransaction();
		
		ContaPagar contaPagar = scp.find(ContaPagar.class, idContaPagar);
		
		scp.getTransaction().commit();
		scp.close();
		return contaPagar;
	}

}

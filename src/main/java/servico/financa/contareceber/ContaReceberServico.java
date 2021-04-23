package main.java.servico.financa.contareceber;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.financa.contareceber.IContaReceber;
import main.java.modelo.financa.contareceber.ContaReceber;
import main.java.sessao.Sessao;

public class ContaReceberServico implements IContaReceber {

	@Override
	public Serializable criarContaReceber(ContaReceber contaReceber) {
		Session sCcr = Sessao.getSessionFactory().openSession();
		sCcr.beginTransaction();
		
		Serializable scr = sCcr.save(contaReceber);
		
		sCcr.getTransaction().commit();
		sCcr.close();
		return scr;
	}

	@Override
	public ContaReceber encontrarContaReceber(Long idContaReceber) {
		Session secr = Sessao.getSessionFactory().openSession();
		secr.beginTransaction();
		
		ContaReceber contaReceber = secr.find(ContaReceber.class, idContaReceber);
		
		secr.getTransaction().commit();
		secr.close();
		return contaReceber;
	}

}

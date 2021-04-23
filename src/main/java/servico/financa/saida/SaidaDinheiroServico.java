package main.java.servico.financa.saida;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.financa.saida.ISaidaDinheiro;
import main.java.modelo.financa.saidadinheiro.SaidaDinheiro;
import main.java.sessao.Sessao;

public class SaidaDinheiroServico implements ISaidaDinheiro {

	@Override
	public Serializable criarSaidaDinheiro(SaidaDinheiro saidaDinheiro) {
		Session scsd = Sessao.getSessionFactory().openSession();
		scsd.beginTransaction();
		
		Serializable ssd = scsd.save(saidaDinheiro);
		
		scsd.getTransaction().commit();
		scsd.close();
		return ssd;
	}

	@Override
	public SaidaDinheiro encontrarSaidaDinheiro(Long idSaidaDinheiro) {
		Session sesd = Sessao.getSessionFactory().openSession();
		sesd.beginTransaction();
		
		SaidaDinheiro saidaDinheiro = sesd.find(SaidaDinheiro.class, idSaidaDinheiro);
		
		sesd.getTransaction().commit();
		sesd.close();
		return saidaDinheiro;
	}

}

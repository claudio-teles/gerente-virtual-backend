package main.java.servico.financa.entrada;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.financa.entrada.IEntradaDinheiro;
import main.java.modelo.financa.entrada.EntradaDinheiro;
import main.java.sessao.Sessao;

public class EntradaDinheiroServico implements IEntradaDinheiro {

	@Override
	public Serializable criarEntradaDinheiro(EntradaDinheiro entradaDinheiro) {
		Session sced = Sessao.getSessionFactory().openSession();
		sced.beginTransaction();
		
		Serializable sed = sced.save(entradaDinheiro);
		
		sced.getTransaction().commit();
		sced.close();
		return sed;
	}

	@Override
	public EntradaDinheiro encontrarEntradaDinheiro(Long idEntradaDinheiro) {
		Session seed = Sessao.getSessionFactory().openSession();
		seed.beginTransaction();
		
		EntradaDinheiro entradaDinheiro = seed.find(EntradaDinheiro.class, idEntradaDinheiro);
		
		seed.getTransaction().commit();
		seed.close();
		return entradaDinheiro;
	}

}

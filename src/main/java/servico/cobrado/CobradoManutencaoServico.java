package main.java.servico.cobrado;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.consertomanutencao.IManutencao;
import main.java.modelo.cobrado.CobradoManutencao;
import main.java.sessao.Sessao;

public class CobradoManutencaoServico implements IManutencao {

	@Override
	public Serializable criarCobradoManutencao(CobradoManutencao itemCobradoManutencao) {
		Session sessionCriarItem = Sessao.getSessionFactory().openSession();
		sessionCriarItem.beginTransaction();
		
		Serializable sci = sessionCriarItem.save(itemCobradoManutencao);
		
		sessionCriarItem.getTransaction().commit();
		sessionCriarItem.close();
		return sci;
	}

	@Override
	public CobradoManutencao encontrarCobradoManutencao(Long idItemCobradoManutencao) {
		Session sessionEncontrarItem = Sessao.getSessionFactory().openSession();
		sessionEncontrarItem.beginTransaction();
		
		CobradoManutencao itemCobradoManutencao = sessionEncontrarItem.find(CobradoManutencao.class, idItemCobradoManutencao);
		
		sessionEncontrarItem.getTransaction().commit();
		sessionEncontrarItem.close();
		return itemCobradoManutencao;
	}

}

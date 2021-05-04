package main.java.dao.cobrado;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.consertomanutencao.IManutencao;
import main.java.modelo.cobrado.CobradoManutencao;
import main.java.sessao.Sessao;

public class CobradoManutencaoDAO implements IManutencao {

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

	@Override
	public Boolean atualizarEstoqueManutencao(CobradoManutencao cobradoManutencao) {
		if (cobradoManutencao != null) {
			Session sessionAtualizarEM = Sessao.getSessionFactory().openSession();
			sessionAtualizarEM.beginTransaction();
			
			sessionAtualizarEM.saveOrUpdate(cobradoManutencao);
			
			sessionAtualizarEM.getTransaction().commit();
			sessionAtualizarEM.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarEstoqueManutencao(CobradoManutencao cobradoManutencao) {
		if (cobradoManutencao != null) {
			Session sessionDeletarEM = Sessao.getSessionFactory().openSession();
			sessionDeletarEM.beginTransaction();
			
			sessionDeletarEM.delete(cobradoManutencao);
			
			sessionDeletarEM.getTransaction().commit();
			sessionDeletarEM.close();
			return true;
		}
		return false;
	}

}

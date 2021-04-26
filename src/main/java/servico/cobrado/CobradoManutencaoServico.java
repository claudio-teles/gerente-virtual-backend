package main.java.servico.cobrado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.java.interfaces.consertomanutencao.IManutencao;
import main.java.modelo.cobrado.CobradoManutencao;
import main.java.modelo.estoque.manutencao.EstoqueManutencao;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<EstoqueManutencao> encotrarTodosEstoqueManutencao() {
		Session sencontrarEM = Sessao.getSessionFactory().openSession();
		sencontrarEM.beginTransaction();
		
		Query queryEM = sencontrarEM.createQuery("FROM EstoqueManutencao ORDER BY idEstoqueManutencao ASC");
		
		List<EstoqueManutencao> estoquesManutencao = new ArrayList<>();
		estoquesManutencao = queryEM.getResultList();
		
		sencontrarEM.getTransaction().commit();
		sencontrarEM.close();
		return estoquesManutencao;
	}

	@Override
	public Boolean atualizarEstoqueManutencao(EstoqueManutencao estoqueManutencao) {
		if (estoqueManutencao.getIdEstoqueManutencao() != null) {
			Session sessionAtualizarEM = Sessao.getSessionFactory().openSession();
			sessionAtualizarEM.beginTransaction();
			
			sessionAtualizarEM.saveOrUpdate(estoqueManutencao);
			
			sessionAtualizarEM.getTransaction().commit();
			sessionAtualizarEM.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarEstoqueManutencao(EstoqueManutencao estoqueManutencao) {
		if (estoqueManutencao.getIdEstoqueManutencao() != null) {
			Session sessionDeletarEM = Sessao.getSessionFactory().openSession();
			sessionDeletarEM.beginTransaction();
			
			sessionDeletarEM.delete(estoqueManutencao);
			
			sessionDeletarEM.getTransaction().commit();
			sessionDeletarEM.close();
			return true;
		}
		return false;
	}

}

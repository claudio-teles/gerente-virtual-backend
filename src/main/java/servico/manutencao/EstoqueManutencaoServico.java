package main.java.servico.manutencao;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.manutencao.IManutencao;
import main.java.modelo.estoque.manutencao.EstoqueManutencao;
import main.java.sessao.Sessao;

public class EstoqueManutencaoServico implements IManutencao {

	@Override
	public Serializable criarEstoqueManutencao(EstoqueManutencao estoqueManutencao) {
		Session cem = Sessao.getSessionFactory().openSession();
		cem.beginTransaction();
		
		Serializable cM = cem.save(estoqueManutencao);
		
		cem.getTransaction().commit();
		cem.close();
		return cM;
	}

	@Override
	public EstoqueManutencao encontrarEstoqueManutencao(Long idEstoqueManutencao) {
		Session cm = Sessao.getSessionFactory().openSession();
		cm.beginTransaction();
		
		EstoqueManutencao estoqueManutencao = cm.find(EstoqueManutencao.class, idEstoqueManutencao);
		
		cm.getTransaction().commit();
		cm.close();
		return estoqueManutencao;
	}

	@Override
	public Boolean deletarEstoqueManutencao(EstoqueManutencao estoqueManutencao) {
		if (estoqueManutencao.getIdEstoqueManutencao() != null) {
			Session sdem = Sessao.getSessionFactory().openSession();
			sdem.beginTransaction();
			
			sdem.delete(estoqueManutencao);
			
			sdem.getTransaction().commit();
			sdem.close();
			return false;
		}
		return false;
	}

}

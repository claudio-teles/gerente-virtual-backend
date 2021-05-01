package main.java.servico.financa.entrada;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<EntradaDinheiro> encontrarTodasEntradasDinheiroPaginacao(Integer inicio, Integer maximo) {
		Session seted = Sessao.getSessionFactory().openSession();
		seted.beginTransaction();
		
		Query queryLseted = seted.createQuery("FROM EntradaDinheiro ORDER BY idEntradaDinheiro ASC");
		queryLseted.setFirstResult(inicio);
		queryLseted.setMaxResults(maximo);
		
		List<EntradaDinheiro> entradasDinheiro = queryLseted.getResultList();
		
		seted.getTransaction().commit();
		seted.close();
		return entradasDinheiro;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntradaDinheiro> encontrarTodasEntradasDinheiro(Calendar dataInicial, Calendar dataFinal) {
		Session seted = Sessao.getSessionFactory().openSession();
		seted.beginTransaction();
		
		Query queryLseted = seted.createQuery("FROM EntradaDinheiro WHERE dataInicial >= :dataInicial AND dataFinal <= :dataFinal ORDER BY idEntradaDinheiro ASC");
		queryLseted.setParameter("dataInicial", dataInicial);
		queryLseted.setParameter("dataFinal", dataFinal);
		
		List<EntradaDinheiro> entradasDinheiro = queryLseted.getResultList();
		seted.getTransaction().commit();
		seted.close();
		return entradasDinheiro;
	}

	@Override
	public Boolean atualizarEntradaDinheiro(EntradaDinheiro entradaDinheiro) {
		if (entradaDinheiro.getIdEntradaDinheiro() != null) {
			Session saed = Sessao.getSessionFactory().openSession();
			saed.beginTransaction();
			
			saed.saveOrUpdate(entradaDinheiro);
			
			saed.getTransaction().commit();
			saed.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarEntradaDinheiro(EntradaDinheiro entradaDinheiro) {
		if (entradaDinheiro.getIdEntradaDinheiro() != null) {
			Session sded = Sessao.getSessionFactory().openSession();
			sded.beginTransaction();
			
			sded.delete(entradaDinheiro);
			
			sded.getTransaction().commit();
			sded.close();
			return true;
		}
		return false;
	}


}

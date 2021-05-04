package main.java.dao.financa.saida;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.interfaces.financa.saida.ISaidaDinheiro;
import main.java.modelo.financa.saidadinheiro.SaidaDinheiro;
import main.java.sessao.Sessao;

public class SaidaDinheiroDAO implements ISaidaDinheiro {

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<SaidaDinheiro> encontrarTodasSaidas(Calendar dataInicial, Calendar dataFinal) {
		Session sesd = Sessao.getSessionFactory().openSession();
		sesd.beginTransaction();
		
		Query querysesd = sesd.createQuery(
				"FROM SaidaDinheiro WHERE dataInicial >= :dataInicial AND dataFinal <= :dataFinal ORDER BY idSaidaDinheiro ASC");
		querysesd.setParameter("dataInicial", dataInicial);
		querysesd.setParameter("dataFinal", dataFinal);
		
		List<SaidaDinheiro> saidas =  querysesd.getResultList();
		
		sesd.getTransaction().commit();
		sesd.close();
		return saidas;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<SaidaDinheiro> encontrarTodasSaidasPaginacao(Integer inicio, Integer maximo) {
		Session sesd = Sessao.getSessionFactory().openSession();
		sesd.beginTransaction();
		
		Query querysesd = sesd.createQuery(
				"FROM SaidaDinheiro WHERE dataInicial >= :dataInicial AND dataFinal <= :dataFinal ORDER BY idSaidaDinheiro ASC");
		querysesd.setFirstResult(inicio);
		querysesd.setMaxResults(maximo);
		
		List<SaidaDinheiro> saidas =  querysesd.getResultList();
		
		sesd.getTransaction().commit();
		sesd.close();
		return saidas;
	}

	@Override
	public Boolean atualizar(SaidaDinheiro saidaDinheiro) {
		if (saidaDinheiro.getIdSaidaDinheiro() != null) {
			Session sesd = Sessao.getSessionFactory().openSession();
			sesd.beginTransaction();
			
			sesd.saveOrUpdate(saidaDinheiro);;
			
			sesd.getTransaction().commit();
			sesd.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletar(SaidaDinheiro saidaDinheiro) {
		if (saidaDinheiro.getIdSaidaDinheiro() != null) {
			Session sesd = Sessao.getSessionFactory().openSession();
			sesd.beginTransaction();
			
			sesd.delete(saidaDinheiro);;
			
			sesd.getTransaction().commit();
			sesd.close();
			return true;
		}
		return false;
	}

}

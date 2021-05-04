package main.java.dao.financa.contapagar;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.java.interfaces.financa.contapagar.IContaPagar;
import main.java.modelo.financa.contapagar.ContaPagar;
import main.java.sessao.Sessao;

public class ContaPagarDAO implements IContaPagar {

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

	@Override
	public ContaPagar encontarContaPagarIdCompra(Long idCompra) {
		Session secp = Sessao.getSessionFactory().openSession();
		secp.beginTransaction();
		
		Query queryecp = secp.createQuery("FROM ContaPagar WHERE idCompra = :idCompra");
		queryecp.setParameter("idCompra", idCompra);
		
		ContaPagar contaPagar = (ContaPagar) queryecp.getSingleResult();
		
		secp.getTransaction().commit();
		secp.close();
		return contaPagar;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContaPagar> encontrarTodasContasPagar() {
		Session setcp = Sessao.getSessionFactory().openSession();
		setcp.beginTransaction();
		
		Query queryectp = setcp.createQuery("FROM ContaPagar ORDER BY idContaPagar ASC");
		
		List<ContaPagar> contasPagar = queryectp.getResultList();
		
		setcp.getTransaction().commit();
		setcp.close();
		return contasPagar;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContaPagar> encontrarTodasContasPagar(Calendar dataPagamento) {
		Session setcp = Sessao.getSessionFactory().openSession();
		setcp.beginTransaction();
		
		Query queryectp = setcp.createQuery("FROM ContaPagar WHERE dataPagamento = :dataPagamento ORDER BY idContaPagar ASC");
		queryectp.setParameter("dataPagamento", dataPagamento);
		
		List<ContaPagar> contasPagar = queryectp.getResultList();
		
		setcp.getTransaction().commit();
		setcp.close();
		return contasPagar;
	}

	@Override
	public Boolean atualizarContaPagar(ContaPagar contaPagar) {
		if (contaPagar.getIdContaPagar() != null) {
			Session sacp = Sessao.getSessionFactory().openSession();
			sacp.beginTransaction();
			
			sacp.saveOrUpdate(contaPagar);
			
			sacp.getTransaction().commit();
			sacp.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarContaPagar(ContaPagar contaPagar) {
		if (contaPagar.getIdContaPagar() != null) {
			Session sdcp = Sessao.getSessionFactory().openSession();
			sdcp.beginTransaction();
			
			sdcp.delete(contaPagar);
			
			sdcp.getTransaction().commit();
			sdcp.close();
			return true;
		}
		return false;
	}

}

package main.java.servico.financa.contareceber;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

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

	@Override
	public ContaReceber encontrarContaReceberIdVenda(Long idVenda) {
		Session secr= Sessao.getSessionFactory().openSession();
		secr.beginTransaction();
		
		Query queryLsecr = secr.createQuery("FROM ContaReceber WHERE idVenda = :idVenda");
		queryLsecr.setParameter("idVenda", idVenda);
		
		ContaReceber contaReceber = (ContaReceber) queryLsecr.getSingleResult();
		
		
		secr.getTransaction().commit();
		secr.close();
		return contaReceber;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContaReceber> encontrarContasReceber() {
		Session secr= Sessao.getSessionFactory().openSession();
		secr.beginTransaction();
		
		Query queryLsecr = secr.createQuery("FROM ContaReceber ORDER BY idContaReceber ASC");
		List<ContaReceber> contasReceber = queryLsecr.getResultList();
		
		secr.getTransaction().commit();
		secr.close();
		return contasReceber;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContaReceber> encontrarContasReceber(Calendar dataRecebimento) {
		Session secr= Sessao.getSessionFactory().openSession();
		secr.beginTransaction();
		
		Query queryLsecr = secr.createQuery("FROM ContaReceber WHERE dataRecebimento = :dataRecebimento ORDER BY idContaReceber ASC");
		List<ContaReceber> contasReceber = queryLsecr.getResultList();
		
		secr.getTransaction().commit();
		secr.close();
		return contasReceber;
	}

	@Override
	public Boolean atualizarContasReceber(ContaReceber contaReceber) {
		if (contaReceber.getIdContaReceber() != null) {
			Session sacr = Sessao.getSessionFactory().openSession();
			sacr.beginTransaction();
			
			sacr.saveOrUpdate(contaReceber);
			
			sacr.getTransaction().commit();
			sacr.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarContasReceber(ContaReceber contaReceber) {
		if (contaReceber.getIdContaReceber() != null) {
			Session sdcr = Sessao.getSessionFactory().openSession();
			sdcr.beginTransaction();
			
			sdcr.delete(contaReceber);
			
			sdcr.getTransaction().commit();
			sdcr.close();
			return true;
		}
		return false;
	}

}

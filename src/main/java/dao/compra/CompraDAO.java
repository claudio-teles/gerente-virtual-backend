package main.java.dao.compra;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.java.interfaces.compra.ICompra;
import main.java.modelo.compra.Compra;
import main.java.sessao.Sessao;

public class CompraDAO implements ICompra {

	@Override
	public Serializable criarCompra(Compra compra) {
		Session scc = Sessao.getSessionFactory().openSession();
		scc.beginTransaction();
		
		Serializable sC = scc.save(compra);
		
		scc.getTransaction().commit();
		scc.close();
		return sC;
	}

	@Override
	public Compra encontrarCompra(Long idCompra) {
		Session sec = Sessao.getSessionFactory().openSession();
		sec.beginTransaction();
		
		Compra compra = sec.find(Compra.class, idCompra);
		
		sec.getTransaction().commit();
		sec.close();
		return compra;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> listarTodasCompras() {
		Session sltc = Sessao.getSessionFactory().openSession();
		sltc.beginTransaction();
		
		Query queryLtc = sltc.createQuery("FROM Compra ORDER BY idCompra ASC");
		List<Compra> compras = queryLtc.getResultList();
		
		sltc.getTransaction().commit();
		sltc.close();
		return compras;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> listarTodasCompras(Calendar dataCompra) {
		Session sltc = Sessao.getSessionFactory().openSession();
		sltc.beginTransaction();
		
		Query queryLtc = sltc.createQuery("FROM Compra WHERE dataCompra = :dataCompra ORDER BY idCompra ASC");
		queryLtc.setParameter("dataCompra", dataCompra);
		
		List<Compra> compras = queryLtc.getResultList();
		
		sltc.getTransaction().commit();
		sltc.close();
		return compras;
	}

	@Override
	public Boolean atualizarCompra(Compra compra) {
		if (compra.getIdCompra() != null) {
			Session sac = Sessao.getSessionFactory().openSession();
			sac.beginTransaction();
			
			sac.saveOrUpdate(compra);
			
			sac.getTransaction().commit();
			sac.close();
			return false;
		}
		return false;
	}

	@Override
	public Boolean deletarCompra(Compra compra) {
		if (compra.getIdCompra() != null) {
			Session sdc = Sessao.getSessionFactory().openSession();
			sdc.beginTransaction();
			
			sdc.delete(compra);
			
			sdc.getTransaction().commit();
			sdc.close();
			return false;
		}
		return false;
	}

}

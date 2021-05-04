package main.java.dao.mercadoria;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.interfaces.mercadoria.IMercadoria;
import main.java.modelo.mercadoria.Mercadoria;
import main.java.sessao.Sessao;

public class MercadoriaDAO implements IMercadoria {

	@Override
	public Serializable criarMercadoria(Mercadoria mercadoria) {
		Session sessionMercadoria = Sessao.getSessionFactory().openSession();
		sessionMercadoria.beginTransaction();
		
		Serializable sm = sessionMercadoria.save(mercadoria);
		
		sessionMercadoria.getTransaction().commit();
		sessionMercadoria.close();
		return sm;
	}

	@Override
	public Mercadoria encontrarMercadoria(Long idMercadoria) {
		Session sM = Sessao.getSessionFactory().openSession();
		sM.beginTransaction();
		
		Mercadoria mercadoria = sM.find(Mercadoria.class, idMercadoria);
		
		sM.getTransaction().commit();
		sM.close();
		return mercadoria;
	}

	@Override
	public Set<Mercadoria> encontrarTodasMercadorias() {
		Session sEtm = Sessao.getSessionFactory().openSession();
		sEtm.beginTransaction();
		
		CriteriaBuilder builder = sEtm.getCriteriaBuilder();
		CriteriaQuery<Mercadoria> query = builder.createQuery(Mercadoria.class);
		Root<Mercadoria> root = query.from(Mercadoria.class);
		query.select(root).orderBy(builder.asc(root.get("idMercadoria")));
		Query<Mercadoria> q = sEtm.createQuery(query);
		List<Mercadoria> list = q.getResultList();
		
		Set<Mercadoria> mercadorias = new HashSet<>();
		
		list.forEach(mercadoria -> {
			mercadorias.add(mercadoria);
		});
		
		sEtm.getTransaction().commit();
		sEtm.close();
		return mercadorias;
	}

	@Override
	public String atualizarMercadoria(Mercadoria mercadoria) {
		if (mercadoria != null) {
			Session sAm = Sessao.getSessionFactory().openSession();
			sAm.beginTransaction();
			
			sAm.saveOrUpdate(mercadoria);
			
			sAm.getTransaction().commit();
			sAm.close();
			return "Atualizou! ";
		}
		return "Não atualizou! ";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Mercadoria encontrarMercadoriaCodBarra(String codigoBarraMercadoria) {
		Session sem = Sessao.getSessionFactory().openSession();
		sem.beginTransaction();
		
		Query querysem = sem.createQuery("FROM Mercadoria WHERE codigoBarraMercadoria = :codigoBarraMercadoria");
		querysem.setParameter("codigoBarraMercadoria", codigoBarraMercadoria);
		
		Mercadoria mercadoria = (Mercadoria) querysem.getSingleResult();
		
		sem.getTransaction().commit();
		sem.close();
		return mercadoria;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Mercadoria> listarMercadoriasDataAquisicao(Calendar dataAquisicaoMercadoria) {
		Session slmd = Sessao.getSessionFactory().openSession();
		slmd.beginTransaction();
		
		Query queryLslmd = slmd.createQuery(
				"FROM Mercadoria WHERE dataAquisicaoMercadoria = :dataAquisicaoMercadoria ORDER BY idMercadoria ASC");
		queryLslmd.setParameter("dataAquisicaoMercadoria", dataAquisicaoMercadoria);
		
		List<Mercadoria> mercadorias = queryLslmd.getResultList();
		
		slmd.getTransaction().commit();
		slmd.close();
		return mercadorias;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Mercadoria> listarMercadoriasDataVencimento(Calendar dataVencimentoMercadoria) {
		Session slmd = Sessao.getSessionFactory().openSession();
		slmd.beginTransaction();
		
		Query queryLslmd = slmd.createQuery(
				"FROM Mercadoria WHERE dataVencimentoMercadoria = :dataVencimentoMercadoria ORDER BY idMercadoria ASC");
		queryLslmd.setParameter("dataVencimentoMercadoria", dataVencimentoMercadoria);
		
		List<Mercadoria> mercadorias = queryLslmd.getResultList();
		
		slmd.getTransaction().commit();
		slmd.close();
		return mercadorias;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Mercadoria> listarMercadorias() {
		Session slmd = Sessao.getSessionFactory().openSession();
		slmd.beginTransaction();
		
		Query queryLslmd = slmd.createQuery(
				"FROM Mercadoria ORDER BY idMercadoria ASC");
		
		List<Mercadoria> mercadorias = queryLslmd.getResultList();
		
		slmd.getTransaction().commit();
		slmd.close();
		return mercadorias;
	}

	@Override
	public Boolean deletarMercadoria(Mercadoria mercadoria) {
		if (mercadoria.getIdMercadoria() != null) {
			Session sM = Sessao.getSessionFactory().openSession();
			sM.beginTransaction();
			
			sM.delete(mercadoria);
			
			sM.getTransaction().commit();
			sM.close();
			return true;
		}
		return false;
	}

}

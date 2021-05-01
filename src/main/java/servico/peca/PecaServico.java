package main.java.servico.peca;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.interfaces.peca.IPeca;
import main.java.modelo.peca.Peca;
import main.java.sessao.Sessao;

public class PecaServico implements IPeca {

	@Override
	public Serializable criarPeca(Peca peca) {
		Session scp = Sessao.getSessionFactory().openSession();
		scp.beginTransaction();
		
		Serializable sp = scp.save(peca);
		
		scp.getTransaction().commit();
		scp.close();
		return sp;
	}

	@Override
	public Peca encontrarPeca(Long idPeca) {
		Session sP = Sessao.getSessionFactory().openSession();
		sP.beginTransaction();
		
		Peca peca = sP.find(Peca.class, idPeca);
		
		sP.getTransaction().commit();
		sP.close();
		return peca;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Peca encontrarPecaCodigo(String codigoPeca) {
		Session sepc = Sessao.getSessionFactory().openSession();
		sepc.beginTransaction();
		
		Query querysepc = sepc.createQuery(
				"FROM Peca WHERE codigoPeca = :codigoPeca ORDER BY idPeca ASC");
		querysepc.setParameter("codigoPeca", codigoPeca);
		
		Peca peca = (Peca) querysepc.getSingleResult();
		
		sepc.getTransaction().commit();
		sepc.close();
		return peca;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Peca> encontrarPecasDescricao(String descricao) {
		Session sepd = Sessao.getSessionFactory().openSession();
		sepd.beginTransaction();
		
		Query queryLsepd = sepd.createQuery(
				"FROM Peca WHERE descricao LIKE :descricao ORDER BY idPeca ASC");
		queryLsepd.setParameter("descricao", "%"+descricao.toLowerCase()+"%");
		
		List<Peca> pecas = queryLsepd.getResultList();
		
		sepd.getTransaction().commit();
		sepd.close();
		return pecas;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Peca> encontrarPecasFabricante(String fabricante) {
		Session sepf = Sessao.getSessionFactory().openSession();
		sepf.beginTransaction();
		
		Query queryLsepf = sepf.createQuery(
				"FROM Peca WHERE fabricante LIKE :fabricante ORDER BY idPeca ASC");
		queryLsepf.setParameter("fabricante", "%"+fabricante.toLowerCase()+"%");
		
		List<Peca> pecas = queryLsepf.getResultList();
		
		sepf.getTransaction().commit();
		sepf.close();
		return pecas;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Peca> encontrarPecasLocal(String localEstaGuardado) {
		Session sepl = Sessao.getSessionFactory().openSession();
		sepl.beginTransaction();
		
		Query queryLsepl = sepl.createQuery(
				"FROM Peca WHERE localEstaGuardado LIKE :localEstaGuardado ORDER BY idPeca ASC");
		queryLsepl.setParameter("localEstaGuardado", "%"+localEstaGuardado.toLowerCase()+"%");
		
		List<Peca> pecas = queryLsepl.getResultList();
		
		sepl.getTransaction().commit();
		sepl.close();
		return pecas;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Peca> encontrarPecasNome(String nomeDaPeca) {
		Session sepn = Sessao.getSessionFactory().openSession();
		sepn.beginTransaction();
		
		Query queryLsepn = sepn.createQuery(
				"FROM Peca WHERE nomeDaPeca LIKE :nomeDaPeca ORDER BY idPeca ASC");
		queryLsepn.setParameter("nomeDaPeca", "%"+nomeDaPeca.toLowerCase()+"%");
		
		List<Peca> pecas = queryLsepn.getResultList();
		
		sepn.getTransaction().commit();
		sepn.close();
		return pecas;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Peca> encontrarPecas() {
		Session sep = Sessao.getSessionFactory().openSession();
		sep.beginTransaction();
		
		Query queryLsep = sep.createQuery(
				"FROM Peca ORDER BY idPeca ASC");
		
		List<Peca> pecas = queryLsep.getResultList();
		
		sep.getTransaction().commit();
		sep.close();
		return pecas;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Peca> encontrarPecasPaginacao(Integer inicio, Integer maximo) {
		Session sepp = Sessao.getSessionFactory().openSession();
		sepp.beginTransaction();
		
		Query queryLsepp = sepp.createQuery(
				"FROM Peca ORDER BY idPeca ASC");
		queryLsepp.setFirstResult(inicio);
		queryLsepp.setMaxResults(maximo);
		
		List<Peca> pecas = queryLsepp.getResultList();
		
		sepp.getTransaction().commit();
		sepp.close();
		return pecas;
	}

	@Override
	public Boolean atualizarPeca(Peca peca) {
		if (peca.getIdPeca() != null) {
			Session sap = Sessao.getSessionFactory().openSession();
			sap.beginTransaction();
			
			sap.saveOrUpdate(peca);
			
			sap.getTransaction().commit();
			sap.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarPeca(Peca peca) {
		if (peca.getIdPeca() != null) {
			Session sdp = Sessao.getSessionFactory().openSession();
			sdp.beginTransaction();
			
			sdp.delete(peca);
			
			sdp.getTransaction().commit();
			sdp.close();
			return true;
		}
		return false;
	}

}

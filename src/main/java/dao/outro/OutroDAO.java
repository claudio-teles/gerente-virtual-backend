package main.java.dao.outro;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.interfaces.outro.IOutro;
import main.java.modelo.outro.Outro;
import main.java.sessao.Sessao;

public class OutroDAO implements IOutro {

	@Override
	public Serializable criarOutro(Outro outro) {
		Session sco = Sessao.getSessionFactory().openSession();
		sco.beginTransaction();
		
		Serializable sO = sco.save(outro);
		
		sco.getTransaction().commit();
		sco.close();
		return sO;
	}

	@Override
	public Outro encontrarOutro(Long idOutro) {
		Session so = Sessao.getSessionFactory().openSession();
		so.beginTransaction();
		
		Outro outro = so.find(Outro.class, idOutro);
		
		so.getTransaction().commit();
		so.close();
		return outro;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Outro encontrarOutroIdentificacador(String identificacador) {
		Session seoi = Sessao.getSessionFactory().openSession();
		seoi.beginTransaction();
		
		Query queryseoi = seoi.createQuery(
				"FROM Outro WHERE identificacador = :identificacador");
		queryseoi.setParameter("identificacador", identificacador);
		
		Outro outro = (Outro) queryseoi.getSingleResult();
		
		seoi.getTransaction().commit();
		seoi.close();
		return outro;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Outro> encontrarTodosDescricao(String descricao) {
		Session std = Sessao.getSessionFactory().openSession();
		std.beginTransaction();
		
		Query queryLstd = std.createQuery(
				"FROM Outro WHERE descricao LIKE :descricao ORDER BY idOutro ASC");
		queryLstd.setParameter("descricao", "%"+descricao.toLowerCase()+"%");
		
		List<Outro> outros = queryLstd.getResultList();
		
		std.getTransaction().commit();
		std.close();
		return outros;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Outro> encontrarTodosFabricante(String fabricante) {
		Session stf = Sessao.getSessionFactory().openSession();
		stf.beginTransaction();
		
		Query queryLstf = stf.createQuery(
				"FROM Outro WHERE fabricante LIKE :fabricante ORDER BY idOutro ASC");
		queryLstf.setParameter("fabricante", "%"+fabricante.toLowerCase()+"%");
		
		List<Outro> outros = queryLstf.getResultList();
		
		stf.getTransaction().commit();
		stf.close();
		return outros;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Outro> encontrarTodosLocal(String localOndeGuardado) {
		Session stl = Sessao.getSessionFactory().openSession();
		stl.beginTransaction();
		
		Query queryLstl = stl.createQuery(
				"FROM Outro WHERE localOndeGuardado LIKE :localOndeGuardado ORDER BY idOutro ASC");
		queryLstl.setParameter("localOndeGuardado", "%"+localOndeGuardado.toLowerCase()+"%");
		
		List<Outro> outros = queryLstl.getResultList();
		
		stl.getTransaction().commit();
		stl.close();
		return outros;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Outro> encontrarTodosNome(String nome) {
		Session stn = Sessao.getSessionFactory().openSession();
		stn.beginTransaction();
		
		Query queryLstn = stn.createQuery(
				"FROM Outro WHERE nome LIKE :nome ORDER BY idOutro ASC");
		queryLstn.setParameter("nome", "%"+nome.toLowerCase()+"%");
		
		List<Outro> outros = queryLstn.getResultList();
		
		stn.getTransaction().commit();
		stn.close();
		return outros;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Outro> encontrarTodosNome() {
		Session stn = Sessao.getSessionFactory().openSession();
		stn.beginTransaction();
		
		Query queryLstn = stn.createQuery(
				"FROM Outro ORDER BY idOutro ASC");
		
		List<Outro> outros = queryLstn.getResultList();
		
		stn.getTransaction().commit();
		stn.close();
		return outros;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Outro> encontrarTodosPaginacao(Integer inicio, Integer maximo) {
		Session stn = Sessao.getSessionFactory().openSession();
		stn.beginTransaction();
		
		Query queryLstn = stn.createQuery(
				"FROM Outro ORDER BY idOutro ASC");
		queryLstn.setFirstResult(inicio);
		queryLstn.setMaxResults(maximo);
		
		List<Outro> outros = queryLstn.getResultList();
		
		stn.getTransaction().commit();
		stn.close();
		return outros;
	}

	@Override
	public Boolean atualizar(Outro outro) {
		if (outro.getIdOutro() != null) {
			Session soa = Sessao.getSessionFactory().openSession();
			soa.beginTransaction();
			
			soa.saveOrUpdate(outro);
			
			soa.getTransaction().commit();
			soa.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletar(Outro outro) {
		if (outro.getIdOutro() != null) {
			Session sod = Sessao.getSessionFactory().openSession();
			sod.beginTransaction();
			
			sod.delete(outro);
			
			sod.getTransaction().commit();
			sod.close();
			return true;
		}
		return false;
	}

}

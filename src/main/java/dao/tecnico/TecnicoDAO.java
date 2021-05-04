package main.java.dao.tecnico;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.interfaces.tecnico.ITecnico;
import main.java.modelo.tecnico.Tecnico;
import main.java.sessao.Sessao;

public class TecnicoDAO implements ITecnico {

	@Override
	public Serializable criarTecnico(Tecnico tecnico) {
		Session sct = Sessao.getSessionFactory().openSession();
		sct.beginTransaction();
		
		Serializable sC = sct.save(tecnico);
		
		sct.getTransaction().commit();
		sct.close();
		return sC;
	}

	@Override
	public Tecnico encontrarTecnico(Long idTecnico) {
		Session st = Sessao.getSessionFactory().openSession();
		st.beginTransaction();
		
		Tecnico tecnico = st.find(Tecnico.class, idTecnico);
		
		st.getTransaction().commit();
		st.close();
		return tecnico;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Tecnico> encontrarTecnicos() {
		Session set = Sessao.getSessionFactory().openSession();
		set.beginTransaction();
		
		Query queryset = set.createQuery(
				"FROM Tecnico ORDER BY idTecnico ASC");
		
		List<Tecnico> tecnicos =  queryset.getResultList();
		
		set.getTransaction().commit();
		set.close();
		return tecnicos;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Tecnico> encontrarTecnicos(String areaEspecializacao) {
		Session set = Sessao.getSessionFactory().openSession();
		set.beginTransaction();
		
		Query queryset = set.createQuery(
				"FROM Tecnico WHERE areaEspecializacao LIKE :areaEspecializacao ORDER BY idTecnico ASC");
		queryset.setParameter("areaEspecializacao", "%"+areaEspecializacao.toLowerCase()+"%");
		
		List<Tecnico> tecnicos =  queryset.getResultList();
		
		set.getTransaction().commit();
		set.close();
		return tecnicos;
	}

	@Override
	public Boolean atualizar(Tecnico tecnico) {
		if (tecnico.getIdTecnico() != null) {
			Session sat = Sessao.getSessionFactory().openSession();
			sat.beginTransaction();
			
			sat.saveOrUpdate(tecnico);
			
			sat.getTransaction().commit();
			sat.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletar(Tecnico tecnico) {
		if (tecnico.getIdTecnico() != null) {
			Session sdt = Sessao.getSessionFactory().openSession();
			sdt.beginTransaction();
			
			sdt.delete(tecnico);
			
			sdt.getTransaction().commit();
			sdt.close();
			return true;
		}
		return false;
	}

}

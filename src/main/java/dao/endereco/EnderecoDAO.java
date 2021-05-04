package main.java.dao.endereco;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.java.interfaces.endereco.IEndereco;
import main.java.modelo.endereco.Endereco;
import main.java.sessao.Sessao;

public class EnderecoDAO implements IEndereco {

	@Override
	public Serializable criarEndereco(Endereco endereco) {
		Session sce = Sessao.getSessionFactory().openSession();
		sce.beginTransaction();
		
		Serializable sC = sce.save(endereco);
		
		sce.getTransaction().commit();
		sce.close();
		return sC;
	}

	@Override
	public Endereco encontrarEndereco(Long idEndereco) {
		Session se = Sessao.getSessionFactory().openSession();
		se.beginTransaction();
		
		Endereco endereco = se.find(Endereco.class, idEndereco);
		
		se.getTransaction().commit();
		se.close();
		return endereco;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> encontrarEndereco(String cep) {
		Session see2 = Sessao.getSessionFactory().openSession();
		see2.beginTransaction();
		
		Query queryLsee2 = see2.createQuery("FROM Endereco WHERE cep = :cep ORDER BY idEndereco ASC");
		queryLsee2.setParameter("cep", cep);
		
		List<Endereco> enderecos = queryLsee2.getResultList();
		
		see2.getTransaction().commit();
		see2.close();
		return enderecos;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Endereco> encontrarEnderecos() {
		Session see = Sessao.getSessionFactory().openSession();
		see.beginTransaction();
		
		Query queryLsee = see.createQuery("FROM Endereco ORDER BY idEndereco ASC");
		List<Endereco> enderecos = queryLsee.getResultList();
		
		see.getTransaction().commit();
		see.close();
		return enderecos;
	}

	@Override
	public Boolean atualizarEndereco(Endereco endereco) {
		if (endereco.getIdEndereco() != null) {
			Session sA = Sessao.getSessionFactory().openSession();
			sA.beginTransaction();
			
			sA.saveOrUpdate(endereco);
			
			sA.getTransaction().commit();
			sA.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarEndereco(Endereco endereco) {
		if (endereco.getIdEndereco() != null) {
			Session sD = Sessao.getSessionFactory().openSession();
			sD.beginTransaction();
			
			sD.delete(endereco);
			
			sD.getTransaction().commit();
			sD.close();
			return true;
		}
		return false;
	}

}

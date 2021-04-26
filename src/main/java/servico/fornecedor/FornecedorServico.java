package main.java.servico.fornecedor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.java.interfaces.fornecedor.IFornecedor;
import main.java.modelo.fornecedor.Fornecedor;
import main.java.sessao.Sessao;

public class FornecedorServico implements IFornecedor {

	@Override
	public Serializable criarFornecedor(Fornecedor fornecedor) {
		Session sCf = Sessao.getSessionFactory().openSession();
		sCf.beginTransaction();
		
		Serializable sc = sCf.save(fornecedor);
		
		sCf.getTransaction().commit();
		sCf.close();
		return sc;
	}

	@Override
	public Fornecedor encontrarFornecedor(Long idFornecedor) {
		Session sC = Sessao.getSessionFactory().openSession();
		sC.beginTransaction();
		
		Fornecedor fornecedor = sC.find(Fornecedor.class, idFornecedor);
		
		sC.getTransaction().commit();
		sC.close();
		return fornecedor;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Fornecedor> encontrarFornecedores() {
		Session sef = Sessao.getSessionFactory().openSession();
		sef.beginTransaction();
		
		Query queryLsef = sef.createQuery("FROM Fornecedor WHERE ORDER BY idFornecedor ASC");
		List<Fornecedor> fornecedores = queryLsef.getResultList();
		
		sef.getTransaction().commit();
		sef.close();
		return fornecedores;
	}

	@Override
	public Boolean atualizarFornecedor(Fornecedor fornecedor) {
		if (fornecedor.getIdFornecedor() != null) {
			Session sA = Sessao.getSessionFactory().openSession();
			sA.beginTransaction();
			
			sA.saveOrUpdate(fornecedor);;
			
			sA.getTransaction().commit();
			sA.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletararFornecedor(Fornecedor fornecedor) {
		if (fornecedor.getIdFornecedor() != null) {
			Session sD = Sessao.getSessionFactory().openSession();
			sD.beginTransaction();
			
			sD.delete(fornecedor);
			
			sD.getTransaction().commit();
			sD.close();
			return true;
		}
		return false;
	}

}

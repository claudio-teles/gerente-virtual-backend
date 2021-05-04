package main.java.dao.vendedor;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.interfaces.vendedor.IVendedor;
import main.java.modelo.vendedor.Vendedor;
import main.java.sessao.Sessao;

public class VendedorDAO implements IVendedor {

	@Override
	public Serializable criarVendedor(Vendedor vendedor) {
		Session scv = Sessao.getSessionFactory().openSession();
		scv.beginTransaction();
		
		Serializable sCv = scv.save(vendedor);
		
		scv.getTransaction().commit();
		scv.close();
		return sCv;
	}

	@Override
	public Vendedor encontrarVendedor(Long idVendedor) {
		Session sv = Sessao.getSessionFactory().openSession();
		sv.beginTransaction();
		
		Vendedor vendedor = sv.find(Vendedor.class, idVendedor);
		
		sv.getTransaction().commit();
		sv.close();
		return vendedor;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Vendedor> encontrarVendedores() {
		Session sev = Sessao.getSessionFactory().openSession();
		sev.beginTransaction();
		
		Query querysev = sev.createQuery(
				"FROM Vendedor ORDER BY idVendedor ASC");
		
		List<Vendedor> vendedores =  querysev.getResultList();
		
		sev.getTransaction().commit();
		sev.close();
		return vendedores;
	}

	@Override
	public Boolean atualizar(Vendedor vendedor) {
		if (vendedor.getIdVendedor() != null) {
			Session sav = Sessao.getSessionFactory().openSession();
			sav.beginTransaction();
			
			sav.saveOrUpdate(vendedor);
			
			sav.getTransaction().commit();
			sav.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletar(Vendedor vendedor) {
		if (vendedor.getIdVendedor() != null) {
			Session sdv = Sessao.getSessionFactory().openSession();
			sdv.beginTransaction();
			
			sdv.delete(vendedor);
			
			sdv.getTransaction().commit();
			sdv.close();
			return true;
		}
		return false;
	}

}

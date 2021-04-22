package main.java.servico.vendedor;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.vendedor.IVendedor;
import main.java.modelo.vendedor.Vendedor;
import main.java.sessao.Sessao;

public class VendedorServico implements IVendedor {

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

}

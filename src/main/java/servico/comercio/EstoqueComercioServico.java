package main.java.servico.comercio;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.comercio.IEstoqueComercio;
import main.java.modelo.estoque.comercio.EstoqueComercio;
import main.java.sessao.Sessao;

public class EstoqueComercioServico implements IEstoqueComercio {

	@Override
	public Serializable criarEstoqueMercadoriaComercio(EstoqueComercio estoqueComercio) {
		Session scem = Sessao.getSessionFactory().openSession();
		scem.beginTransaction();
		
		Serializable sCem = scem.save(estoqueComercio);
		
		scem.getTransaction().commit();
		scem.close();
		return sCem;
	}

	@Override
	public EstoqueComercio encontrarMercadoriaEstoque(Long idMercadoriaEstoqueComercio) {
		Session sm = Sessao.getSessionFactory().openSession();
		sm.beginTransaction();
		
		EstoqueComercio estoqueMercadoriaComercio = sm.find(EstoqueComercio.class, idMercadoriaEstoqueComercio);
		
		sm.getTransaction().commit();
		sm.close();
		return estoqueMercadoriaComercio;
	}

}

package main.java.servico.produto;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.produto.IProduto;
import main.java.modelo.produto.Produto;
import main.java.sessao.Sessao;

public class ProdutoServico implements IProduto {

	@Override
	public Serializable criarProduto(Produto produto) {
		Session scp = Sessao.getSessionFactory().openSession();
		scp.beginTransaction();
		
		Serializable sCp = scp.save(produto);
		
		scp.getTransaction().commit();
		scp.close();
		return sCp;
	}

	@Override
	public Produto encontrarProduto(Long idProduto) {
		Session sp = Sessao.getSessionFactory().openSession();
		sp.beginTransaction();
		
		Produto produto = sp.find(Produto.class, idProduto);
		
		sp.getTransaction().commit();
		sp.close();
		return produto;
	}

}

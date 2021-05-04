package main.java.dao.produto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.interfaces.produto.IProduto;
import main.java.modelo.produto.Produto;
import main.java.sessao.Sessao;

public class ProdutoDAO implements IProduto {

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

	@SuppressWarnings("rawtypes")
	@Override
	public Produto encontrarProdutoIdentificador(String identificadorProduto) {
		Session sepi = Sessao.getSessionFactory().openSession();
		sepi.beginTransaction();
		
		Query querysepi = sepi.createQuery(
				"FROM Produto WHERE identificadorProduto = :identificadorProduto ORDER BY idProduto ASC");
		querysepi.setParameter("identificadorProduto", identificadorProduto);
		
		Produto produto = (Produto) querysepi.getSingleResult();
		
		sepi.getTransaction().commit();
		sepi.close();
		return produto;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Produto> encontrarTodosProdutos() {
		Session setp1 = Sessao.getSessionFactory().openSession();
		setp1.beginTransaction();
		
		Query queryLsetp1 = setp1.createQuery(
				"FROM Produto ORDER BY idProduto ASC");
		
		List<Produto> produtos = queryLsetp1.getResultList();
		
		setp1.getTransaction().commit();
		setp1.close();
		return produtos;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Produto> encontrarTodosProdutosPaginacao(Integer inicio, Integer maximo) {
		Session setp2 = Sessao.getSessionFactory().openSession();
		setp2.beginTransaction();
		
		Query querysetp2 = setp2.createQuery(
				"FROM Produto ORDER BY idProduto ASC");
		querysetp2.setFirstResult(inicio);
		querysetp2.setMaxResults(maximo);
		
		List<Produto> produtos = querysetp2.getResultList();
		
		setp2.getTransaction().commit();
		setp2.close();
		return produtos;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Produto> encontrarTodosProdutosDescricao(String descricao) {
		Session setp3 = Sessao.getSessionFactory().openSession();
		setp3.beginTransaction();
		
		Query queryLsetp3 = setp3.createQuery(
				"FROM Produto WHERE descricao LIKE :descricao ORDER BY idProduto ASC");
		queryLsetp3.setParameter("descricao", "%"+descricao.toLowerCase()+"%");
		
		List<Produto> produtos = queryLsetp3.getResultList();
		
		setp3.getTransaction().commit();
		setp3.close();
		return produtos;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Produto> encontrarTodosProdutosFabricante(String fabricante) {
		Session setp4 = Sessao.getSessionFactory().openSession();
		setp4.beginTransaction();
		
		Query queryLsetp4 = setp4.createQuery(
				"FROM Produto WHERE fabricante LIKE :fabricante ORDER BY idProduto ASC");
		queryLsetp4.setParameter("fabricante", "%"+fabricante.toLowerCase()+"%");
		
		List<Produto> produtos = queryLsetp4.getResultList();
		
		setp4.getTransaction().commit();
		setp4.close();
		return produtos;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Produto> encontrarTodosProdutosLocal(String localEstaGuardado) {
		Session setp5 = Sessao.getSessionFactory().openSession();
		setp5.beginTransaction();
		
		Query queryLsetp5 = setp5.createQuery(
				"FROM Produto WHERE localEstaGuardado LIKE :localEstaGuardado ORDER BY idProduto ASC");
		queryLsetp5.setParameter("localEstaGuardado", "%"+localEstaGuardado.toLowerCase()+"%");
		
		List<Produto> produtos = queryLsetp5.getResultList();
		
		setp5.getTransaction().commit();
		setp5.close();
		return produtos;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Produto> encontrarTodosProdutosNome(String nome) {
		Session setp6 = Sessao.getSessionFactory().openSession();
		setp6.beginTransaction();
		
		Query queryLsetp6 = setp6.createQuery(
				"FROM Produto WHERE nome LIKE :nome ORDER BY idProduto ASC");
		queryLsetp6.setParameter("nome", "%"+nome.toLowerCase()+"%");
		
		List<Produto> produtos = queryLsetp6.getResultList();
		
		setp6.getTransaction().commit();
		setp6.close();
		return produtos;
	}

	@Override
	public Boolean atualizarProduto(Produto produto) {
		if (produto.getIdProduto() != null) {
			Session sap = Sessao.getSessionFactory().openSession();
			sap.beginTransaction();
			
			sap.saveOrUpdate(produto);
			
			sap.getTransaction().commit();
			sap.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarProduto(Produto produto) {
		if (produto.getIdProduto() != null) {
			Session sdp = Sessao.getSessionFactory().openSession();
			sdp.beginTransaction();
			
			sdp.delete(produto);
			
			sdp.getTransaction().commit();
			sdp.close();
			return true;
		}
		return false;
	}

}

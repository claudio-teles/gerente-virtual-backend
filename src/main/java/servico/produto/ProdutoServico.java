package main.java.servico.produto;

import java.io.Serializable;
import java.util.List;

import main.java.dao.produto.ProdutoDAO;
import main.java.modelo.produto.Produto;

public class ProdutoServico {
	
	private ProdutoDAO produtoDAO = new ProdutoDAO();

	public Serializable criarProduto(Produto produto) {
		if (produto != null) {
			return produtoDAO.criarProduto(produto);
		}
		return null;
	}

	public Produto encontrarProduto(Long idProduto) {
		if (idProduto != null) {
			return produtoDAO.encontrarProduto(idProduto);
		}
		return null;
	}

	public Produto encontrarProdutoIdentificador(String identificadorProduto) {
		if ( !(identificadorProduto.equals("") || identificadorProduto.equals(null)) ) {
			return produtoDAO.encontrarProdutoIdentificador(identificadorProduto);
		}
		return null;
	}

	public List<Produto> encontrarTodosProdutos() {
		return produtoDAO.encontrarTodosProdutos();
	}

	public List<Produto> encontrarTodosProdutosPaginacao(Integer inicio, Integer maximo) {
		if ( !(inicio.equals(null) || maximo.equals(null)) ) {
			return produtoDAO.encontrarTodosProdutosPaginacao(inicio, maximo);
		}
		return null;
	}

	public List<Produto> encontrarTodosProdutosDescricao(String descricao) {
		if ( !(descricao.equals("") || descricao.equals(null)) ) {
			return produtoDAO.encontrarTodosProdutosDescricao(descricao);
		}
		return null;
	}

	public List<Produto> encontrarTodosProdutosFabricante(String fabricante) {
		if ( !(fabricante.equals("") || fabricante.equals(null)) ) {
			return produtoDAO.encontrarTodosProdutosFabricante(fabricante);
		}
		return null;
	}

	public List<Produto> encontrarTodosProdutosLocal(String localEstaGuardado) {
		if ( !(localEstaGuardado.equals("") || localEstaGuardado.equals(null)) ) {
			return produtoDAO.encontrarTodosProdutosLocal(localEstaGuardado);
		}
		return null;
	}

	public List<Produto> encontrarTodosProdutosNome(String nome) {
		if ( !(nome.equals("") || nome.equals(null)) ) {
			return produtoDAO.encontrarTodosProdutosNome(nome);
		}
		return null;
	}

	public Boolean atualizarProduto(Produto produto) {
		return produtoDAO.atualizarProduto(produto);
	}

	public Boolean deletarProduto(Produto produto) {
		return produtoDAO.deletarProduto(produto);
	}

}

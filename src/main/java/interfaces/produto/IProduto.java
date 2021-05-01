package main.java.interfaces.produto;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.produto.Produto;

public interface IProduto {
	
	public Serializable criarProduto(Produto produto);
	public Produto encontrarProduto(Long idProduto);
	public Produto encontrarProdutoIdentificador(String identificadorProduto);
	public List<Produto> encontrarTodosProdutos();
	public List<Produto> encontrarTodosProdutosPaginacao(Integer inicio, Integer maximo);
	public List<Produto> encontrarTodosProdutosDescricao(String descricao);
	public List<Produto> encontrarTodosProdutosFabricante(String fabricante);
	public List<Produto> encontrarTodosProdutosLocal(String localEstaGuardado);
	public List<Produto> encontrarTodosProdutosNome(String nome);
	public Boolean atualizarProduto(Produto produto);
	public Boolean deletarProduto(Produto produto);

}

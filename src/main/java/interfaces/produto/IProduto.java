package main.java.interfaces.produto;

import java.io.Serializable;

import main.java.modelo.produto.Produto;

public interface IProduto {
	
	public Serializable criarProduto(Produto produto);
	public Produto encontrarProduto(Long idProduto);

}

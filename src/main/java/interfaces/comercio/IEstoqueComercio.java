package main.java.interfaces.comercio;

import java.io.Serializable;

import main.java.modelo.estoque.comercio.EstoqueComercio;

public interface IEstoqueComercio {
	
	public Serializable criarEstoqueMercadoriaComercio(EstoqueComercio estoqueComercio);
	public EstoqueComercio encontrarMercadoriaEstoque(Long idMercadoriaEstoqueComercio);

}

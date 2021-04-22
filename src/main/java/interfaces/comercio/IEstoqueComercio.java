package main.java.interfaces.comercio;

import java.io.Serializable;
import java.util.Set;

import main.java.modelo.estoque.comercio.EstoqueComercio;
import main.java.modelo.mercadoria.Mercadoria;

public interface IEstoqueComercio {
	
	public Serializable criarEstoqueMercadoriaComercio(EstoqueComercio estoqueComercio);
	public EstoqueComercio encontrarMercadoriaEstoque(Long idMercadoriaEstoqueComercio);
	public Set<Mercadoria> encontrarTodasMercadoriaEstoque(Long idMercadoriaEstoqueComercio);

}

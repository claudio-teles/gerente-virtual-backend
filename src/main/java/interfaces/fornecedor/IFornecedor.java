package main.java.interfaces.fornecedor;

import java.io.Serializable;

import main.java.modelo.fornecedor.Fornecedor;

public interface IFornecedor {
	
	public Serializable criarFornecedor(Fornecedor fornecedor);
	public Fornecedor encontrarFornecedor(Long idFornecedor);

}

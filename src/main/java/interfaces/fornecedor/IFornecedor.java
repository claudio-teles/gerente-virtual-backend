package main.java.interfaces.fornecedor;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.fornecedor.Fornecedor;

public interface IFornecedor {
	
	public Serializable criarFornecedor(Fornecedor fornecedor);
	public Fornecedor encontrarFornecedor(Long idFornecedor);
	public List<Fornecedor> encontrarFornecedores();
	public Boolean atualizarFornecedor(Fornecedor fornecedor);
	public Boolean deletararFornecedor(Fornecedor fornecedor);

}

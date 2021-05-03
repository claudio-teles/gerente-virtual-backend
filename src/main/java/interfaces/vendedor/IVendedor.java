package main.java.interfaces.vendedor;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.vendedor.Vendedor;

public interface IVendedor {
	
	public Serializable criarVendedor(Vendedor vendedor);
	public Vendedor encontrarVendedor(Long idVendedor);
	public List<Vendedor> encontrarVendedores();
	public Boolean atualizar(Vendedor vendedor);
	public Boolean deletar(Vendedor vendedor);

}

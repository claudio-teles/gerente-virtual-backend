package main.java.interfaces.vendedor;

import java.io.Serializable;

import main.java.modelo.vendedor.Vendedor;

public interface IVendedor {
	
	public Serializable criarVendedor(Vendedor vendedor);
	public Vendedor encontrarVendedor(Long idVendedor);

}

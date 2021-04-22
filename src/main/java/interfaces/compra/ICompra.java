package main.java.interfaces.compra;

import java.io.Serializable;

import main.java.modelo.compra.Compra;

public interface ICompra {
	
	public Serializable criarCompra(Compra compra);
	public Compra encontrarCompra(Long idCompra);

}

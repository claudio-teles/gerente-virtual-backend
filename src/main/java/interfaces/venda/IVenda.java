package main.java.interfaces.venda;

import java.io.Serializable;

import main.java.modelo.venda.Venda;

public interface IVenda {
	
	public Serializable criarVenda(Venda venda);
	public Venda encontrarVenda(Long idVenda);

}

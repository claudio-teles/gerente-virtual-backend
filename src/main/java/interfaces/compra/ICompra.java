package main.java.interfaces.compra;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.modelo.compra.Compra;

public interface ICompra {
	
	public Serializable criarCompra(Compra compra);
	public Compra encontrarCompra(Long idCompra);
	public List<Compra> listarTodasCompras();
	public List<Compra> listarTodasCompras(Calendar dataCompra);
	public Boolean atualizarCompra(Compra compra);
	public Boolean deletarCompra(Compra compra);

}

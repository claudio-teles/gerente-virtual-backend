package main.java.interfaces.venda;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.modelo.venda.Venda;

public interface IVenda {
	
	public Serializable criarVenda(Venda venda);
	public Venda encontrarVenda(Long idVenda);
	public List<Venda> encontrarVendas();
	public List<Venda> encontrarVendas(Calendar dataVenda);
	public List<Venda> encontrarVendasPaginacao(Integer inicio, Integer maximo);
	public Boolean atualizar(Venda venda);
	public Boolean deletar(Venda venda);

}

package main.java.interfaces.financa.contapagar;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.modelo.financa.contapagar.ContaPagar;

public interface IContaPagar {
	
	public Serializable criarContaPagar(ContaPagar contaPagar);
	public ContaPagar encontarContaPagar(Long idContaPagar);
	public ContaPagar encontarContaPagarIdCompra(Long idCompra);
	public List<ContaPagar> encontrarTodasContasPagar();
	public List<ContaPagar> encontrarTodasContasPagar(Calendar dataPagamento);
	public Boolean atualizarContaPagar(ContaPagar contaPagar);
	public Boolean deletarContaPagar(ContaPagar contaPagar);

}

package main.java.interfaces.financa.contareceber;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.modelo.financa.contareceber.ContaReceber;

public interface IContaReceber {
	
	public Serializable criarContaReceber(ContaReceber contaReceber);
	public ContaReceber encontrarContaReceber(Long idContaReceber);
	public ContaReceber encontrarContaReceberIdVenda(Long idVenda);
	public List<ContaReceber> encontrarContasReceber();
	public List<ContaReceber> encontrarContasReceber(Calendar dataRecebimento);
	public Boolean atualizarContasReceber(ContaReceber contaReceber);
	public Boolean deletarContasReceber(ContaReceber contaReceber);

}

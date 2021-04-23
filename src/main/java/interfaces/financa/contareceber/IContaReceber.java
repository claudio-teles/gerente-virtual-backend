package main.java.interfaces.financa.contareceber;

import java.io.Serializable;

import main.java.modelo.financa.contareceber.ContaReceber;

public interface IContaReceber {
	
	public Serializable criarContaReceber(ContaReceber contaReceber);
	public ContaReceber encontrarContaReceber(Long idContaReceber);

}

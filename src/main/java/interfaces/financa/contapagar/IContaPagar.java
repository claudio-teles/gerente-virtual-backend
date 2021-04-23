package main.java.interfaces.financa.contapagar;

import java.io.Serializable;

import main.java.modelo.financa.contapagar.ContaPagar;

public interface IContaPagar {
	
	public Serializable criarContaPagar(ContaPagar contaPagar);
	public ContaPagar encontarContaPagar(Long idContaPagar);

}

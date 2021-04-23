package main.java.interfaces.financa.saida;

import java.io.Serializable;

import main.java.modelo.financa.saidadinheiro.SaidaDinheiro;

public interface ISaidaDinheiro {
	
	public Serializable criarSaidaDinheiro(SaidaDinheiro saidaDinheiro);
	public SaidaDinheiro encontrarSaidaDinheiro(Long idSaidaDinheiro);

}

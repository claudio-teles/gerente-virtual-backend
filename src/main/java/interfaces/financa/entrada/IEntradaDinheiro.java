package main.java.interfaces.financa.entrada;

import java.io.Serializable;

import main.java.modelo.financa.entrada.EntradaDinheiro;

public interface IEntradaDinheiro {
	
	public Serializable criarEntradaDinheiro(EntradaDinheiro entradaDinheiro);
	public EntradaDinheiro encontrarEntradaDinheiro(Long idEntradaDinheiro);

}

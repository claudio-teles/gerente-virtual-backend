package main.java.interfaces.peca;

import java.io.Serializable;

import main.java.modelo.peca.Peca;

public interface IPeca {
	
	public Serializable criarPeca(Peca peca);
	public Peca encontrarPeca(Long idPeca);

}

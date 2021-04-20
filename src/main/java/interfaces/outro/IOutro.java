package main.java.interfaces.outro;

import java.io.Serializable;

import main.java.modelo.outro.Outro;

public interface IOutro {
	
	public Serializable criarOutro(Outro outro);
	public Outro encontrarOutro(Long idOutro);

}

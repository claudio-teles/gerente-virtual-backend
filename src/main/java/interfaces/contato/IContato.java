package main.java.interfaces.contato;

import java.io.Serializable;

import main.java.modelo.contato.Contato;

public interface IContato {
	
	public Serializable criarContato(Contato contato);
	public Contato encotrarContato(Long idContato);

}

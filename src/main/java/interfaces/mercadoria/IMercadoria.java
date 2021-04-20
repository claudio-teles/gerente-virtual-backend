package main.java.interfaces.mercadoria;

import java.io.Serializable;

import main.java.modelo.mercadoria.Mercadoria;

public interface IMercadoria {
	
	public Serializable criarMercadoria(Mercadoria mercadoria);
	public Mercadoria encontrarMercadoria(Long idMercadoria);

}

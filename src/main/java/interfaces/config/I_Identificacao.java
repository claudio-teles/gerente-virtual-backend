package main.java.interfaces.config;

import java.io.Serializable;

import main.java.modelo.identificacao.Identificacao;

public interface I_Identificacao {
	
	public Serializable criarIdentificacao(Identificacao identificacao);
	public Identificacao encontrarIdentificacao(Long idIdentificacao);

}

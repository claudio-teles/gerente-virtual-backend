package main.java.interfaces.empreendimento;

import java.io.Serializable;

import main.java.modelo.empreendimento.Empreendimento;

public interface IEmpreendimento {
	
	public Serializable criarEmpreendimento(Empreendimento empreendimento);
	public Empreendimento encontrarEmpreendimento(Long idEmpreendimento);

}

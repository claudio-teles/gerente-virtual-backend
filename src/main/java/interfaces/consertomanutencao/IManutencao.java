package main.java.interfaces.consertomanutencao;

import java.io.Serializable;

import main.java.modelo.cobrado.CobradoManutencao;

public interface IManutencao {
	
	public Serializable criarCobradoManutencao(CobradoManutencao itemCobradoManutencao);
	public CobradoManutencao encontrarCobradoManutencao(Long idItemCobradoManutencao);

}

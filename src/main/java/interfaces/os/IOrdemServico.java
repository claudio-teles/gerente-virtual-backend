package main.java.interfaces.os;

import java.io.Serializable;

import main.java.modelo.ordemservico.OrdemServico;

public interface IOrdemServico {
	
	public Serializable criarOrdemServico(OrdemServico ordemServico);
	public OrdemServico encontrarOrdemServico(Long idOrdemServico);

}

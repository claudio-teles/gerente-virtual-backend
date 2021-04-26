package main.java.interfaces.empreendimento;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.empreendimento.Empreendimento;

public interface IEmpreendimento {
	
	public Serializable criarEmpreendimento(Empreendimento empreendimento);
	public Empreendimento encontrarEmpreendimento(Long idEmpreendimento);
	public List<Empreendimento> encontrarEmpreendimentos();
	public Boolean atualizarEmpreendimento(Empreendimento empreendimento);
	public Boolean deletarEmpreendimento(Empreendimento empreendimento);

}

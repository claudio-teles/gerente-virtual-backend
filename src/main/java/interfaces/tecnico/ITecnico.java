package main.java.interfaces.tecnico;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.tecnico.Tecnico;

public interface ITecnico {
	
	public Serializable criarTecnico(Tecnico tecnico);
	public Tecnico encontrarTecnico(Long idTecnico);
	public List<Tecnico> encontrarTecnicos();
	public List<Tecnico> encontrarTecnicos(String areaEspecializacao);
	public Boolean atualizar(Tecnico tecnico);
	public Boolean deletar(Tecnico tecnico);

}

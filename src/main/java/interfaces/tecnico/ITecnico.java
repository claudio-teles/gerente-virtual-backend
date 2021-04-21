package main.java.interfaces.tecnico;

import java.io.Serializable;

import main.java.modelo.tecnico.Tecnico;

public interface ITecnico {
	
	public Serializable criarTecnico(Tecnico tecnico);
	public Tecnico encontrarTecnico(Long idTecnico);

}

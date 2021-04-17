package main.java.interfaces.endereco;

import java.io.Serializable;

import main.java.modelo.endereco.Endereco;

public interface IEndereco {
	
	public Serializable criarEndereco(Endereco endereco);
	public Endereco encontrarEndereco(Long idEndereco);

}

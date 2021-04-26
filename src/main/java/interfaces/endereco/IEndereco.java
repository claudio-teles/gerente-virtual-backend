package main.java.interfaces.endereco;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.endereco.Endereco;

public interface IEndereco {
	
	public Serializable criarEndereco(Endereco endereco);
	public Endereco encontrarEndereco(Long idEndereco);
	public List<Endereco> encontrarEndereco(String cep);
	public List<Endereco> encontrarEnderecos();
	public Boolean atualizarEndereco(Endereco endereco);
	public Boolean deletarEndereco(Endereco endereco);

}

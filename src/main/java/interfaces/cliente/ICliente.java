package main.java.interfaces.cliente;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.cliente.Cliente;
import main.java.modelo.contato.Contato;
import main.java.modelo.endereco.Endereco;
import main.java.modelo.identificacao.Identificacao;

public interface ICliente {
	
	public Serializable criarCliente(Cliente cliente);
	public List<Cliente> encontrarClientesEntre(Integer idade1, Integer idade2);
	public Identificacao encontrarIdentificacao(Long idCliente);
	public Endereco encontrarEndereco(Long idCliente);
	public Contato encontrarContato(Long idCliente);
	public Cliente encontrarCliente(Long idCliente);
	public Cliente encontrarCliente(Integer idade);

}

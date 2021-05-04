package main.java.interfaces.cliente;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.cliente.Cliente;

public interface ICliente {
	
	public Serializable criarCliente(Cliente cliente);
	public List<Cliente> encontrarClientesEntre(Integer idade1, Integer idade2);
	public Cliente encontrarCliente(Long idCliente);
	public Cliente encontrarCliente(Integer idade);
	public Boolean atualizar(Cliente cliente);
	public Boolean deletar(Cliente cliente);

}

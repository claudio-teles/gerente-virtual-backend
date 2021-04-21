package main.java.interfaces.cliente;

import java.io.Serializable;

import main.java.modelo.cliente.Cliente;

public interface ICliente {
	
	public Serializable criarCliente(Cliente cliente);
	public Cliente encontrarCliente(Long idCliente);

}

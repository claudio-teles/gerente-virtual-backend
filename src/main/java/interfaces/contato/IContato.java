package main.java.interfaces.contato;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.contato.Contato;

public interface IContato {
	
	public Serializable criarContato(Contato contato);
	public Contato encotrarContato(Long idContato);
	public Contato encotrarContatoCelular(String celular);
	public Contato encotrarContatoEmail(String email);
	public Contato encotrarContatoSite(String site);
	public Contato encotrarContatoTelefone(String telefone);
	public List<Contato> encontrarContatos();
	public Boolean atualizarContatos(Contato contato);
	public Boolean deletarContatos(Contato contato);

}

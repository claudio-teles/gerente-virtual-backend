package main.java.interfaces.config;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.identificacao.Identificacao;

public interface I_Identificacao {
	
	public Serializable criarIdentificacao(Identificacao identificacao);
	public Identificacao encontrarIdentificacao(Long idIdentificacao);
	public Identificacao encontrarIdentificacaoCnpj(String cnpj);
	public Identificacao encontrarIdentificacaoCpf(String cpf);
	public List<Identificacao> encontrarTodasIdentificacao();
	public Boolean atualizarIdentificacao(Identificacao identificacao);
	public Boolean deletarIdentificacao(Identificacao identificacao);

}

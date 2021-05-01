package main.java.interfaces.financa.saida;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.modelo.financa.saidadinheiro.SaidaDinheiro;

public interface ISaidaDinheiro {
	
	public Serializable criarSaidaDinheiro(SaidaDinheiro saidaDinheiro);
	public SaidaDinheiro encontrarSaidaDinheiro(Long idSaidaDinheiro);
	public List<SaidaDinheiro> encontrarTodasSaidasPaginacao(Integer inicio, Integer maximo);
	public List<SaidaDinheiro> encontrarTodasSaidas(Calendar dataInicial, Calendar dataFinal);
	public Boolean atualizar(SaidaDinheiro saidaDinheiro);
	public Boolean deletar(SaidaDinheiro saidaDinheiro);

}

package main.java.interfaces.financa.entrada;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.modelo.financa.entrada.EntradaDinheiro;

public interface IEntradaDinheiro {
	
	public Serializable criarEntradaDinheiro(EntradaDinheiro entradaDinheiro);
	public EntradaDinheiro encontrarEntradaDinheiro(Long idEntradaDinheiro);
	public List<EntradaDinheiro> encontrarTodasEntradasDinheiroPaginacao(Integer inicio, Integer maximo);
	public List<EntradaDinheiro> encontrarTodasEntradasDinheiro(Calendar dataInicial, Calendar dataFinal);
	public Boolean atualizarEntradaDinheiro(EntradaDinheiro entradaDinheiro);
	public Boolean deletarEntradaDinheiro(EntradaDinheiro entradaDinheiro);

}

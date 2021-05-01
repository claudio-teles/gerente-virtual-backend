package main.java.interfaces.peca;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.peca.Peca;

public interface IPeca {
	
	public Serializable criarPeca(Peca peca);
	public Peca encontrarPeca(Long idPeca);
	public Peca encontrarPecaCodigo(String codigoPeca);
	public List<Peca> encontrarPecasDescricao(String descricao);
	public List<Peca> encontrarPecasFabricante(String fabricante);
	public List<Peca> encontrarPecasLocal(String localEstaGuardado);
	public List<Peca> encontrarPecasNome(String nomeDaPeca);
	public List<Peca> encontrarPecas();
	public List<Peca> encontrarPecasPaginacao(Integer inicio, Integer maximo);
	public Boolean atualizarPeca(Peca peca);
	public Boolean deletarPeca(Peca peca);

}

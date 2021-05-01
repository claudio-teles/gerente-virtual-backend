package main.java.interfaces.outro;

import java.io.Serializable;
import java.util.List;

import main.java.modelo.outro.Outro;

public interface IOutro {
	
	public Serializable criarOutro(Outro outro);
	public Outro encontrarOutro(Long idOutro);
	public Outro encontrarOutroIdentificacador(String identificacador);
	public List<Outro> encontrarTodosDescricao(String descricao);
	public List<Outro> encontrarTodosFabricante(String fabricante);
	public List<Outro> encontrarTodosLocal(String localOndeGuardado);
	public List<Outro> encontrarTodosNome();
	public List<Outro> encontrarTodosNome(String nome);
	public List<Outro> encontrarTodosPaginacao(Integer inicio, Integer maximo);
	public Boolean atualizar(Outro outro);
	public Boolean deletar(Outro outro);

}

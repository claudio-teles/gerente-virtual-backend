package main.java.servico.outro;

import java.io.Serializable;
import java.util.List;

import main.java.dao.outro.OutroDAO;
import main.java.modelo.outro.Outro;

public class OutroServico {
	
	private OutroDAO outroDao = new OutroDAO();

	public Serializable criarOutro(Outro outro) {
		if (outro != null) {
			return outroDao.criarOutro(outro);
		}
		return null;
	}

	public Outro encontrarOutro(Long idOutro) {
		if (idOutro != null) {
			return outroDao.encontrarOutro(idOutro);
		}
		return null;
	}

	public Outro encontrarOutroIdentificacador(String identificacador) {
		if ( !(identificacador.equals("") || identificacador.equals(null)) ) {
			return outroDao.encontrarOutroIdentificacador(identificacador);
		}
		return null;
	}

	public List<Outro> encontrarTodosDescricao(String descricao) {
		if ( !(descricao.equals("") || descricao.equals(null)) ) {
			return outroDao.encontrarTodosDescricao(descricao);
		}
		return null;
	}

	public List<Outro> encontrarTodosFabricante(String fabricante) {
		if ( !(fabricante.equals("") || fabricante.equals(null)) ) {
			return outroDao.encontrarTodosFabricante(fabricante);
		}
		return null;
	}

	public List<Outro> encontrarTodosLocal(String localOndeGuardado) {
		if ( !(localOndeGuardado.equals("") || localOndeGuardado.equals(null)) ) {
			return outroDao.encontrarTodosLocal(localOndeGuardado);
		}
		return null;
	}

	public List<Outro> encontrarTodosNome(String nome) {
		if ( !(nome.equals("") || nome.equals(null)) ) {
			return outroDao.encontrarTodosNome(nome);
		}
		return null;
	}

	public List<Outro> encontrarTodosNome() {
		return outroDao.encontrarTodosNome();
	}

	public List<Outro> encontrarTodosPaginacao(Integer inicio, Integer maximo) {
		if ( !(inicio != null && maximo != null) ) {
			return outroDao.encontrarTodosPaginacao(inicio, maximo);
		}
		return null;
	}

	public Boolean atualizar(Outro outro) {
		return outroDao.atualizar(outro);
	}

	public Boolean deletar(Outro outro) {
		return outroDao.deletar(outro);
	}

}

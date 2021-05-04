package main.java.servico.tecnico;

import java.io.Serializable;
import java.util.List;

import main.java.dao.tecnico.TecnicoDAO;
import main.java.modelo.tecnico.Tecnico;

public class TecnicoServico {
	
	private TecnicoDAO tecnicoDAO = new TecnicoDAO();

	public Serializable criarTecnico(Tecnico tecnico) {
		if (tecnico != null) {
			return tecnicoDAO.criarTecnico(tecnico);
		}
		return null;
	}

	public Tecnico encontrarTecnico(Long idTecnico) {
		if (idTecnico != null) {
			return tecnicoDAO.encontrarTecnico(idTecnico);
		}
		return null;
	}

	public List<Tecnico> encontrarTecnicos() {
		return tecnicoDAO.encontrarTecnicos();
	}

	public List<Tecnico> encontrarTecnicos(String areaEspecializacao) {
		if ( !(areaEspecializacao.equals("") || areaEspecializacao.equals(null)) ) {
			return tecnicoDAO.encontrarTecnicos(areaEspecializacao);
		}
		return null;
	}

	public Boolean atualizar(Tecnico tecnico) {
		return tecnicoDAO.atualizar(tecnico);
	}

	public Boolean deletar(Tecnico tecnico) {
		return tecnicoDAO.deletar(tecnico);
	}

}

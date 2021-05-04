package main.java.servico.empreendimento;

import java.io.Serializable;
import java.util.List;

import main.java.dao.empreendimento.EmpreendimentoDAO;
import main.java.modelo.empreendimento.Empreendimento;

public class EmpreendimentoServico {
	
	private EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();

	public Serializable criarEmpreendimento(Empreendimento empreendimento) {
		if (empreendimento != null) {
			return empreendimentoDAO.criarEmpreendimento(empreendimento);
		}
		return null;
	}

	public Empreendimento encontrarEmpreendimento(Long idEmpreendimento) {
		if (idEmpreendimento != null) {
			return empreendimentoDAO.encontrarEmpreendimento(idEmpreendimento);
		}
		return null;
	}
	
	public List<Empreendimento> encontrarEmpreendimentos() {
		return empreendimentoDAO.encontrarEmpreendimentos();
	}

	public Boolean atualizarEmpreendimento(Empreendimento empreendimento) {
		return empreendimentoDAO.atualizarEmpreendimento(empreendimento);
	}

	public Boolean deletarEmpreendimento(Empreendimento empreendimento) {
		return empreendimentoDAO.deletarEmpreendimento(empreendimento);
	}

}

package main.java.servico.config;

import java.io.Serializable;

import main.java.dao.config.ConfigDAO;
import main.java.modelo.config.Config;

public class ConfigServico {
	
	private ConfigDAO configDAO = new ConfigDAO();

	public Serializable criarConfig(Config config) {
		if (config != null) {
			return configDAO.criarConfig(config);
		}
		return null;
	}

	public Config encontrarConfig(Long idConfig) {
		if (idConfig != null) {
			return configDAO.encontrarConfig(idConfig);
		}
		return null;
	}

	public Boolean atualizarConfig(Config config) {
		return configDAO.atualizarConfig(config);
	}

	public Boolean deletarConfig(Config config) {
		return configDAO.deletarConfig(config);
	}

}

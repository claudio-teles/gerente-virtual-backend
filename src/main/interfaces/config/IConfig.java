package main.interfaces.config;

import java.io.Serializable;

import main.modelo.config.Config;

public interface IConfig {
	
	public Serializable criarConfig(Config config);
	public Config encontrarConfig(Long idConfig);

}

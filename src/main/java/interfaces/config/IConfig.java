package main.java.interfaces.config;

import java.io.Serializable;

import main.java.modelo.config.Config;

public interface IConfig {
	
	public Serializable criarConfig(Config config);
	public Config encontrarConfig(Long idConfig);

}

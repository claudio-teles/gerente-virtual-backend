package main.servico.config;

import java.io.Serializable;

import org.hibernate.Session;

import main.interfaces.config.IConfig;
import main.modelo.config.Config;
import main.sessao.Sessao;

public class ConfigServico implements IConfig {

	@Override
	public Serializable criarConfig(Config config) {
		Session sConf = Sessao.getSessionFactory().openSession();
		sConf.beginTransaction();
		
		Serializable sc = sConf.save(config);
		
		sConf.getTransaction().commit();
		sConf.close();
		return sc;
	}

	@Override
	public Config encontrarConfig(Long idConfig) {
		Session sC = Sessao.getSessionFactory().openSession();
		sC.beginTransaction();
		
		Config config = sC.find(Config.class, idConfig);
		
		sC.getTransaction().commit();
		sC.close();
		return config;
	}

}
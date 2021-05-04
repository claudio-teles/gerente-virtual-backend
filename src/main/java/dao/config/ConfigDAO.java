package main.java.dao.config;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.config.IConfig;
import main.java.modelo.config.Config;
import main.java.sessao.Sessao;

public class ConfigDAO implements IConfig {

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

	@Override
	public Boolean atualizarConfig(Config config) {
		if (config.getIdConfig() != null) {
			Session sA = Sessao.getSessionFactory().openSession();
			sA.beginTransaction();
			
			sA.saveOrUpdate(config);
			
			sA.getTransaction().commit();
			sA.close();
		}
		return false;
	}

	@Override
	public Boolean deletarConfig(Config config) {
		if (config.getIdConfig() != null) {
			Session sA = Sessao.getSessionFactory().openSession();
			sA.beginTransaction();
			
			sA.saveOrUpdate(config);
			
			sA.getTransaction().commit();
			sA.close();
		}
		return false;
	}

}

package main.java.servico.endereco;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.endereco.IEndereco;
import main.java.modelo.endereco.Endereco;
import main.java.sessao.Sessao;

public class EnderecoServico implements IEndereco {

	@Override
	public Serializable criarEndereco(Endereco endereco) {
		Session sce = Sessao.getSessionFactory().openSession();
		sce.beginTransaction();
		
		Serializable sC = sce.save(endereco);
		
		sce.getTransaction().commit();
		sce.close();
		return sC;
	}

	@Override
	public Endereco encontrarEndereco(Long idEndereco) {
		Session se = Sessao.getSessionFactory().openSession();
		se.beginTransaction();
		
		Endereco endereco = se.find(Endereco.class, idEndereco);
		
		se.getTransaction().commit();
		se.close();
		return endereco;
	}

}

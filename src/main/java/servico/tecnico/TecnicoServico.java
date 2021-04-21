package main.java.servico.tecnico;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.tecnico.ITecnico;
import main.java.modelo.tecnico.Tecnico;
import main.java.sessao.Sessao;

public class TecnicoServico implements ITecnico {

	@Override
	public Serializable criarTecnico(Tecnico tecnico) {
		Session sct = Sessao.getSessionFactory().openSession();
		sct.beginTransaction();
		
		Serializable sC = sct.save(tecnico);
		
		sct.getTransaction().commit();
		sct.close();
		return sC;
	}

	@Override
	public Tecnico encontrarTecnico(Long idTecnico) {
		Session st = Sessao.getSessionFactory().openSession();
		st.beginTransaction();
		
		Tecnico tecnico = st.find(Tecnico.class, idTecnico);
		
		st.getTransaction().commit();
		st.close();
		return tecnico;
	}

}

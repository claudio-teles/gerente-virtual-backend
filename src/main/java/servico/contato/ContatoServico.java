package main.java.servico.contato;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import main.java.interfaces.contato.IContato;
import main.java.modelo.contato.Contato;
import main.java.sessao.Sessao;

public class ContatoServico implements IContato {

	@Override
	public Serializable criarContato(Contato contato) {
		Session sCont = Sessao.getSessionFactory().openSession();
		sCont.beginTransaction();
		
		Serializable sc = sCont.save(contato);
		
		sCont.getTransaction().commit();
		sCont.close();
		return sc;
	}

	@Override
	public Contato encotrarContato(Long idContato) {
		Session sC = Sessao.getSessionFactory().openSession();
		sC.beginTransaction();
		
		Contato contato = sC.find(Contato.class, idContato);
		
		sC.getTransaction().commit();
		sC.close();
		return contato;
	}

	@Override
	public Contato encotrarContatoCelular(String celular) {
		if (!( celular.equals("") && celular.equals(null)) ) {
			Session sec2 = Sessao.getSessionFactory().openSession();
			sec2.beginTransaction();
			
			Query queryLsec2 = sec2.createQuery("FROM Contato WHERE celular = :celular");
			queryLsec2.setParameter("celular", celular);
			Contato contato = (Contato) queryLsec2.getSingleResult();
			
			sec2.getTransaction().commit();
			sec2.close();
			return contato;
		}
		return null;
	}

	@Override
	public Contato encotrarContatoEmail(String email) {
		if (!( email.equals("") && email.equals(null)) ) {
			Session sec3 = Sessao.getSessionFactory().openSession();
			sec3.beginTransaction();
			
			Query queryLsec3 = sec3.createQuery("FROM Contato WHERE email = :email");
			queryLsec3.setParameter("email", email);
			Contato contato = (Contato) queryLsec3.getSingleResult();
			
			sec3.getTransaction().commit();
			sec3.close();
			return contato;
		}
		return null;
	}

	@Override
	public Contato encotrarContatoSite(String site) {
		if (!( site.equals("") && site.equals(null)) ) {
			Session sec4 = Sessao.getSessionFactory().openSession();
			sec4.beginTransaction();
			
			Query queryLsec4 = sec4.createQuery("FROM Contato WHERE site = :site");
			queryLsec4.setParameter("site", site);
			Contato contato = (Contato) queryLsec4.getSingleResult();
			
			sec4.getTransaction().commit();
			sec4.close();
			return contato;
		}
		return null;
	}

	@Override
	public Contato encotrarContatoTelefone(String telefone) {
		if (!( telefone.equals("") && telefone.equals(null)) ) {
			Session sec5 = Sessao.getSessionFactory().openSession();
			sec5.beginTransaction();
			
			Query queryLsec4 = sec5.createQuery("FROM Contato WHERE telefone = :telefone");
			queryLsec4.setParameter("telefone", telefone);
			Contato contato = (Contato) queryLsec4.getSingleResult();
			
			sec5.getTransaction().commit();
			sec5.close();
			return contato;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contato> encontrarContatos() {
		Session sec1 = Sessao.getSessionFactory().openSession();
		sec1.beginTransaction();
		
		Query queryLsec1 = sec1.createQuery("FROM Contato ORDER BY idContato ASC");
		List<Contato> contatos = queryLsec1.getResultList();
		
		sec1.getTransaction().commit();
		sec1.close();
		return contatos;
	}

	@Override
	public Boolean atualizarContatos(Contato contato) {
		if (contato.getIdContato() != null) {
			Session sAt = Sessao.getSessionFactory().openSession();
			sAt.beginTransaction();
			
			sAt.saveOrUpdate(contato);
			
			sAt.getTransaction().commit();
			sAt.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarContatos(Contato contato) {
		if (contato.getIdContato() != null) {
			Session sD = Sessao.getSessionFactory().openSession();
			sD.beginTransaction();
			
			sD.delete(contato);
			
			sD.getTransaction().commit();
			sD.close();
			return true;
		}
		return false;
	}

}

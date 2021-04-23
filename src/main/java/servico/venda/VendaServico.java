package main.java.servico.venda;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.venda.IVenda;
import main.java.modelo.venda.Venda;
import main.java.sessao.Sessao;

public class VendaServico implements IVenda {

	@Override
	public Serializable criarVenda(Venda venda) {
		Session sCriarVenda = Sessao.getSessionFactory().openSession();
		sCriarVenda.beginTransaction();
		
		Serializable scv = sCriarVenda.save(venda);
		
		sCriarVenda.getTransaction().commit();
		sCriarVenda.close();
		return scv;
	}

	@Override
	public Venda encontrarVenda(Long idVenda) {
		Session sEncontrarVenda = Sessao.getSessionFactory().openSession();
		sEncontrarVenda.beginTransaction();
		
		Venda venda = sEncontrarVenda.find(Venda.class, idVenda);
		
		sEncontrarVenda.getTransaction().commit();
		sEncontrarVenda.close();
		return venda;
	}

}

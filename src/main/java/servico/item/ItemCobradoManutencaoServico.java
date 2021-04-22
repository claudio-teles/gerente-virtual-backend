package main.java.servico.item;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.item.I_ItemManutencao;
import main.java.modelo.itemcobrado.ItemCobradoManutencao;
import main.java.sessao.Sessao;

public class ItemCobradoManutencaoServico implements I_ItemManutencao {

	@Override
	public Serializable criarItemCobradoManutencao(ItemCobradoManutencao itemCobradoManutencao) {
		Session sessionCriarItem = Sessao.getSessionFactory().openSession();
		sessionCriarItem.beginTransaction();
		
		Serializable sci = sessionCriarItem.save(itemCobradoManutencao);
		
		sessionCriarItem.getTransaction().commit();
		sessionCriarItem.close();
		return sci;
	}

	@Override
	public ItemCobradoManutencao encontrarItemCobradoManutencao(Long idItemCobradoManutencao) {
		Session sessionEncontrarItem = Sessao.getSessionFactory().openSession();
		sessionEncontrarItem.beginTransaction();
		
		ItemCobradoManutencao itemCobradoManutencao = sessionEncontrarItem.find(ItemCobradoManutencao.class, idItemCobradoManutencao);
		
		sessionEncontrarItem.getTransaction().commit();
		sessionEncontrarItem.close();
		return itemCobradoManutencao;
	}

}

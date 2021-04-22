package main.java.interfaces.item;

import java.io.Serializable;

import main.java.modelo.itemcobrado.ItemCobradoManutencao;

public interface I_ItemManutencao {
	
	public Serializable criarItemCobradoManutencao(ItemCobradoManutencao itemCobradoManutencao);
	public ItemCobradoManutencao encontrarItemCobradoManutencao(Long idItemCobradoManutencao);

}

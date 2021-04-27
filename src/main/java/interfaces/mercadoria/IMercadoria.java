package main.java.interfaces.mercadoria;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import main.java.modelo.mercadoria.Mercadoria;

public interface IMercadoria {
	
	public Serializable criarMercadoria(Mercadoria mercadoria);
	public Mercadoria encontrarMercadoria(Long idMercadoria);
	public Set<Mercadoria> encontrarTodasMercadorias();
	public String atualizarMercadoria(Mercadoria mercadoria);
	public Mercadoria encontrarMercadoriaCodBarra(String codigoBarraMercadoria);
	public List<Mercadoria> listarMercadoriasDataAquisicao(Calendar dataAquisicaoMercadoria);
	public List<Mercadoria> listarMercadoriasDataVencimento(Calendar dataVencimentoMercadoria);
	public List<Mercadoria> listarMercadorias();
	public Boolean deletarMercadoria(Mercadoria mercadoria);

}

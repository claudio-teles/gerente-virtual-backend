package main.java.servico.venda;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Venda> encontrarVendas() {
		Session sevp = Sessao.getSessionFactory().openSession();
		sevp.beginTransaction();
		
		Query querysevp = sevp.createQuery(
				"FROM Venda ORDER BY idVenda ASC");
		
		List<Venda> vendas =  querysevp.getResultList();
		
		sevp.getTransaction().commit();
		sevp.close();
		return vendas;
	}

	@Override
	public List<Venda> encontrarVendas(Calendar dataVenda) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Venda> encontrarVendasPaginacao(Integer inicio, Integer maximo) {
		Session sevp = Sessao.getSessionFactory().openSession();
		sevp.beginTransaction();
		
		Query querysevp = sevp.createQuery(
				"FROM Venda ORDER BY idVenda ASC");
		querysevp.setFirstResult(inicio);
		querysevp.setMaxResults(maximo);
		
		List<Venda> vendas =  querysevp.getResultList();
		
		sevp.getTransaction().commit();
		sevp.close();
		return vendas;
	}

	@Override
	public Boolean atualizar(Venda venda) {
		if (venda.getIdVenda() != null) {
			Session sAtualizarVenda = Sessao.getSessionFactory().openSession();
			sAtualizarVenda.beginTransaction();
			
			sAtualizarVenda.saveOrUpdate(venda);
			
			sAtualizarVenda.getTransaction().commit();
			sAtualizarVenda.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletar(Venda venda) {
		if (venda.getIdVenda() != null) {
			Session sDeletarVenda = Sessao.getSessionFactory().openSession();
			sDeletarVenda.beginTransaction();
			
			sDeletarVenda.delete(venda);
			
			sDeletarVenda.getTransaction().commit();
			sDeletarVenda.close();
			return true;
		}
		return false;
	}

}

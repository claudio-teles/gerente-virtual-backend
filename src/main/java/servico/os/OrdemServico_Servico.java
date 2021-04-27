package main.java.servico.os;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import main.java.interfaces.os.IOrdemServico;
import main.java.modelo.ordemservico.OrdemServico;
import main.java.sessao.Sessao;

public class OrdemServico_Servico implements IOrdemServico {

	@Override
	public Serializable criarOrdemServico(OrdemServico ordemServico) {
		Session sessaoCriarOS = Sessao.getSessionFactory().openSession();
		sessaoCriarOS.beginTransaction();
		
		Serializable scos = sessaoCriarOS.save(ordemServico);
		
		sessaoCriarOS.getTransaction().commit();
		sessaoCriarOS.close();
		return scos;
	}

	@Override
	public OrdemServico encontrarOrdemServico(Long idOrdemServico) {
		Session sessaoEncontrarOS = Sessao.getSessionFactory().openSession();
		sessaoEncontrarOS.beginTransaction();
		
		OrdemServico ordemServico = sessaoEncontrarOS.find(OrdemServico.class, idOrdemServico);
		
		sessaoEncontrarOS.getTransaction().commit();
		sessaoEncontrarOS.close();
		return ordemServico;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<OrdemServico> encontrarOrdensServicoDataAberturaOS(Calendar dataAberturaOS) {
		if (!dataAberturaOS.equals(null)) {
			Session sos = Sessao.getSessionFactory().openSession();
			sos.beginTransaction();
			Query queryLsos = sos.createQuery(
					"FROM OrdemServico WHERE dataAberturaOS = :dataAberturaOS ORDER BY idOrdemServico ASC");
			queryLsos.setParameter("dataAberturaOS", dataAberturaOS);
			
			List<OrdemServico> ordensServicos = queryLsos.getResultList();
			
			sos.getTransaction().commit();
			sos.close();
			return ordensServicos;
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<OrdemServico> encontrarOrdensServicoDataFinalizacaoOS(Calendar dataFinalizacaoOS) {
		if (!dataFinalizacaoOS.equals(null)) {
			Session sos = Sessao.getSessionFactory().openSession();
			sos.beginTransaction();
			Query queryLsos = sos.createQuery(
					"FROM OrdemServico WHERE dataFinalizacaoOS = :dataFinalizacaoOS ORDER BY idOrdemServico ASC");
			queryLsos.setParameter("dataFinalizacaoOS", dataFinalizacaoOS);
			
			List<OrdemServico> ordensServicos = queryLsos.getResultList();
			
			sos.getTransaction().commit();
			sos.close();
			return ordensServicos;
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<OrdemServico> encontrarOrdensServicoDataInicioGarantia(Calendar dataInicioGarantia) {
		if (!dataInicioGarantia.equals(null)) {
			Session sos = Sessao.getSessionFactory().openSession();
			sos.beginTransaction();
			Query queryLsos = sos.createQuery(
					"FROM OrdemServico WHERE dataInicioGarantia = :dataInicioGarantia ORDER BY idOrdemServico ASC");
			queryLsos.setParameter("dataInicioGarantia", dataInicioGarantia);
			
			List<OrdemServico> ordensServicos = queryLsos.getResultList();
			
			sos.getTransaction().commit();
			sos.close();
			return ordensServicos;
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<OrdemServico> encontrarOrdensServicoDataPrevisaoTerminoOS(Calendar dataPrevisaoTerminoOS) {
		if (!dataPrevisaoTerminoOS.equals(null)) {
			Session sos = Sessao.getSessionFactory().openSession();
			sos.beginTransaction();
			Query queryLsos = sos.createQuery(
					"FROM OrdemServico WHERE dataPrevisaoTerminoOS = :dataPrevisaoTerminoOS ORDER BY idOrdemServico ASC");
			queryLsos.setParameter("dataPrevisaoTerminoOS", dataPrevisaoTerminoOS);
			
			List<OrdemServico> ordensServicos = queryLsos.getResultList();
			
			sos.getTransaction().commit();
			sos.close();
			return ordensServicos;
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<OrdemServico> encontrarOrdensServicoDataTerminoGarantia(Calendar dataTerminoGarantia) {
		if (!dataTerminoGarantia.equals(null)) {
			Session sos = Sessao.getSessionFactory().openSession();
			sos.beginTransaction();
			Query queryLsos = sos.createQuery(
					"FROM OrdemServico WHERE dataTerminoGarantia = :dataTerminoGarantia ORDER BY idOrdemServico ASC");
			queryLsos.setParameter("dataTerminoGarantia", dataTerminoGarantia);
			
			List<OrdemServico> ordensServicos = queryLsos.getResultList();
			
			sos.getTransaction().commit();
			sos.close();
			return ordensServicos;
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<OrdemServico> encontrarTodasOrdensSerivicos() {
		Session sos = Sessao.getSessionFactory().openSession();
		sos.beginTransaction();
		Query queryLsos = sos.createQuery(
				"FROM OrdemServico ORDER BY idOrdemServico ASC");
		
		List<OrdemServico> ordensServicos = queryLsos.getResultList();
		
		sos.getTransaction().commit();
		sos.close();
		return ordensServicos;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<OrdemServico> encontrarTodasOrdensSerivicosPaginacao(Integer inicio, Integer maximo) {
		Session sos = Sessao.getSessionFactory().openSession();
		sos.beginTransaction();
		Query queryLsos = sos.createQuery(
				"FROM OrdemServico ORDER BY idOrdemServico ASC");
		queryLsos.setFirstResult(inicio);
		queryLsos.setMaxResults(maximo);
		
		List<OrdemServico> ordensServicos = queryLsos.getResultList();
		
		sos.getTransaction().commit();
		sos.close();
		return ordensServicos;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public OrdemServico encontrarOrdensServicoIdCliente(Long idCliente) {
		Session seosc = Sessao.getSessionFactory().openSession();
		seosc.beginTransaction();
		
		Query queryseosc = seosc.createQuery(
				"FROM OrdemServico WHERE idCliente = :idCliente");
		queryseosc.setParameter("idCliente", idCliente);
		
		OrdemServico ordemServico = (OrdemServico) queryseosc.getSingleResult();
		
		seosc.getTransaction().commit();
		seosc.close();
		return ordemServico;
	}

	@Override
	public Boolean atualizarOrdemServico(OrdemServico ordemServico) {
		if (ordemServico.getIdOrdemServico() != null) {
			Session sessaoAtualizarOS = Sessao.getSessionFactory().openSession();
			sessaoAtualizarOS.beginTransaction();
			
			sessaoAtualizarOS.saveOrUpdate(ordemServico);
			
			sessaoAtualizarOS.getTransaction().commit();
			sessaoAtualizarOS.close();
			return true;
		}
		return false;
	}

	@Override
	public Boolean deletarOrdemServico(OrdemServico ordemServico) {
		if (ordemServico.getIdOrdemServico() != null) {
			Session sessaoDeletarOS = Sessao.getSessionFactory().openSession();
			sessaoDeletarOS.beginTransaction();
			
			sessaoDeletarOS.delete(ordemServico);
			
			sessaoDeletarOS.getTransaction().commit();
			sessaoDeletarOS.close();
			return true;
		}
		return false;
	}

}

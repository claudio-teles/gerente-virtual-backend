package main.java.servico.os;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.dao.os.OrdemServicoDAO;
import main.java.modelo.ordemservico.OrdemServico;

public class OrdemServico_Servico {
	
	private OrdemServicoDAO osDAO = new OrdemServicoDAO();

	public Serializable criarOrdemServico(OrdemServico ordemServico) {
		if (ordemServico != null) {
			return osDAO.criarOrdemServico(ordemServico);
		}
		return null;
	}

	public OrdemServico encontrarOrdemServico(Long idOrdemServico) {
		if (idOrdemServico != null) {
			return osDAO.encontrarOrdemServico(idOrdemServico);
		}
		return null;
	}

	public List<OrdemServico> encontrarOrdensServicoDataAberturaOS(Calendar dataAberturaOS) {
		if (!dataAberturaOS.equals(null)) {
			return osDAO.encontrarOrdensServicoDataAberturaOS(dataAberturaOS);
		}
		return null;
	}

	public List<OrdemServico> encontrarOrdensServicoDataFinalizacaoOS(Calendar dataFinalizacaoOS) {
		if (!dataFinalizacaoOS.equals(null)) {
			return osDAO.encontrarOrdensServicoDataFinalizacaoOS(dataFinalizacaoOS);
		}
		return null;
	}

	public List<OrdemServico> encontrarOrdensServicoDataInicioGarantia(Calendar dataInicioGarantia) {
		if (!dataInicioGarantia.equals(null)) {
			return osDAO.encontrarOrdensServicoDataInicioGarantia(dataInicioGarantia);
		}
		return null;
	}

	public List<OrdemServico> encontrarOrdensServicoDataPrevisaoTerminoOS(Calendar dataPrevisaoTerminoOS) {
		if (!dataPrevisaoTerminoOS.equals(null)) {
			return osDAO.encontrarOrdensServicoDataPrevisaoTerminoOS(dataPrevisaoTerminoOS);
		}
		return null;
	}

	public List<OrdemServico> encontrarOrdensServicoDataTerminoGarantia(Calendar dataTerminoGarantia) {
		if (!dataTerminoGarantia.equals(null)) {
			return osDAO.encontrarOrdensServicoDataTerminoGarantia(dataTerminoGarantia);
		}
		return null;
	}

	public List<OrdemServico> encontrarTodasOrdensSerivicos() {
		return osDAO.encontrarTodasOrdensSerivicos();
	}

	public List<OrdemServico> encontrarTodasOrdensSerivicosPaginacao(Integer inicio, Integer maximo) {
		if (inicio != null && maximo != null) {
			return osDAO.encontrarTodasOrdensSerivicosPaginacao(inicio, maximo);
		}
		return null;
	}

	public OrdemServico encontrarOrdensServicoIdCliente(Long idCliente) {
		if (idCliente != null) {
			return osDAO.encontrarOrdensServicoIdCliente(idCliente);
		}
		return null;
	}

	public Boolean atualizarOrdemServico(OrdemServico ordemServico) {
		return osDAO.atualizarOrdemServico(ordemServico);
	}

	public Boolean deletarOrdemServico(OrdemServico ordemServico) {
		return osDAO.deletarOrdemServico(ordemServico);
	}

}

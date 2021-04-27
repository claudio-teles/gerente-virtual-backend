package main.java.interfaces.os;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import main.java.modelo.ordemservico.OrdemServico;

public interface IOrdemServico {
	
	public Serializable criarOrdemServico(OrdemServico ordemServico);
	public OrdemServico encontrarOrdemServico(Long idOrdemServico);
	public List<OrdemServico> encontrarOrdensServicoDataAberturaOS(Calendar dataAberturaOS);
	public List<OrdemServico> encontrarOrdensServicoDataFinalizacaoOS(Calendar dataFinalizacaoOS);
	public List<OrdemServico> encontrarOrdensServicoDataInicioGarantia(Calendar dataInicioGarantia);
	public List<OrdemServico> encontrarOrdensServicoDataPrevisaoTerminoOS(Calendar dataPrevisaoTerminoOS);
	public List<OrdemServico> encontrarOrdensServicoDataTerminoGarantia(Calendar dataTerminoGarantia);
	public List<OrdemServico> encontrarTodasOrdensSerivicos();
	public List<OrdemServico> encontrarTodasOrdensSerivicosPaginacao(Integer inicio, Integer maximo);
	public OrdemServico encontrarOrdensServicoIdCliente(Long idCliente);
	public Boolean atualizarOrdemServico(OrdemServico ordemServico);
	public Boolean deletarOrdemServico(OrdemServico ordemServico);

}

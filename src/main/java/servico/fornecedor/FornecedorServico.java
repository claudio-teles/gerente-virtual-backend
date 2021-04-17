package main.java.servico.fornecedor;

import java.io.Serializable;

import org.hibernate.Session;

import main.java.interfaces.fornecedor.IFornecedor;
import main.java.modelo.fornecedor.Fornecedor;
import main.java.sessao.Sessao;

public class FornecedorServico implements IFornecedor {

	@Override
	public Serializable criarFornecedor(Fornecedor fornecedor) {
		Session sCf = Sessao.getSessionFactory().openSession();
		sCf.beginTransaction();
		
		Serializable sc = sCf.save(fornecedor);
		
		sCf.getTransaction().commit();
		sCf.close();
		return sc;
	}

	@Override
	public Fornecedor encontrarFornecedor(Long idFornecedor) {
		Session sC = Sessao.getSessionFactory().openSession();
		sC.beginTransaction();
		
		Fornecedor fornecedor = sC.find(Fornecedor.class, idFornecedor);
		
		sC.getTransaction().commit();
		sC.close();
		return fornecedor;
	}

}

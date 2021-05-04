package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import main.java.enumeracao.Setor;
import main.java.enumeracao.UnidadeFederativa;
import main.java.modelo.cliente.Cliente;
import main.java.modelo.config.Config;
import main.java.modelo.contato.Contato;
import main.java.modelo.endereco.Endereco;
import main.java.modelo.identificacao.Identificacao;
import main.java.servico.cliente.ClienteServico;
import main.java.servico.config.ConfigServico;
import main.java.servico.contato.ContatoServico;
import main.java.servico.endereco.EnderecoServico;
import main.java.servico.identificacao.IdentificacaoServico;

@TestMethodOrder(OrderAnnotation.class)
class T02 {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Order(1)
	void test01Config() {
		Config configComercio = new Config();
		configComercio.setSetor(Setor.COMERCIO);
		
		Config configManutencao = new Config();
		configManutencao.setSetor(Setor.MANUTENCAO_TECNICA);
		
		Config configHibrido = new Config();
		configHibrido.setSetor(Setor.HIBRIDO);
		
		assertEquals(1L, new ConfigServico().criarConfig(configComercio));
		assertEquals(2L, new ConfigServico().criarConfig(configManutencao));
		assertEquals(3L, new ConfigServico().criarConfig(configHibrido));
	}
	
	@Test
	@Order(2)
	void test02Cliente() {
		
		Identificacao identificacao1 = new Identificacao();
		identificacao1.setCnpj("11.111.111/111-11");
		identificacao1.setCpf("111.111.111-11");
		identificacao1.setNomeFantasia("F1");
		identificacao1.setNomePessoaFisica("Pf1");
		identificacao1.setRazaoSocial("Rs1");
		new IdentificacaoServico().criarIdentificacao(identificacao1);
		
		Endereco endereco1 = new Endereco();
		endereco1.setBairro("Bairro 1");
		endereco1.setCep("11111-111");
		endereco1.setCidade("Cidade 1");
		endereco1.setComplemento("Complemento 1");
		endereco1.setNumero(111);
		endereco1.setPais("Brasil");
		endereco1.setReferencia("Referência 1");
		endereco1.setRua("Rua 1");
		endereco1.setUnidadeFederativa(UnidadeFederativa.ACRE);
		new EnderecoServico().criarEndereco(endereco1);
		
		Contato contato1 = new Contato();
		contato1.setCelular("(11) 9 1111-1111");
		contato1.setEmail("email@clienteum.com");
		contato1.setTelefone("(11) 1111-1111");
		new ContatoServico().criarContato(contato1);
		
		Cliente cliente1 = new Cliente();
		cliente1.setIdentificacao(new IdentificacaoServico().encontrarIdentificacao(4L));
		cliente1.setEndereco(new EnderecoServico().encontrarEndereco(5L));
		cliente1.setContato(new ContatoServico().encotrarContato(6L));
		cliente1.setIdade(25);
		
		assertEquals(7L, new ClienteServico().criarCliente(cliente1));
		
		// --------------------------------------------------------------
		
		Identificacao identificacao2 = new Identificacao();
		identificacao2.setCnpj("11.111.111/111-12");
		identificacao2.setCpf("111.111.111-12");
		identificacao2.setNomeFantasia("F2");
		identificacao2.setNomePessoaFisica("Pf2");
		identificacao1.setRazaoSocial("Rs2");
		new IdentificacaoServico().criarIdentificacao(identificacao2);
		
		Endereco endereco2 = new Endereco();
		endereco2.setBairro("Bairro 2");
		endereco2.setCep("11111-112");
		endereco2.setCidade("Cidade 2");
		endereco2.setComplemento("Complemento 2");
		endereco2.setNumero(112);
		endereco2.setPais("Brasil");
		endereco2.setReferencia("Referência 2");
		endereco2.setRua("Rua 2");
		endereco2.setUnidadeFederativa(UnidadeFederativa.ALAGOAS);
		new EnderecoServico().criarEndereco(endereco2);
		
		Contato contato2 = new Contato();
		contato2.setCelular("(11) 9 1111-1112");
		contato2.setEmail("email@clientedois.com");
		contato2.setTelefone("(11) 1111-1112");
		new ContatoServico().criarContato(contato2);
		
		Cliente cliente2 = new Cliente();
		cliente2.setIdentificacao(new IdentificacaoServico().encontrarIdentificacao(8L));
		cliente2.setEndereco(new EnderecoServico().encontrarEndereco(9L));
		cliente2.setContato(new ContatoServico().encotrarContato(10L));
		cliente2.setIdade(26);
		
		assertEquals(11L, new ClienteServico().criarCliente(cliente2));
		
		// --------------------------------------------------------------
		
		Identificacao identificacao3 = new Identificacao();
		identificacao3.setCnpj("11.111.111/111-13");
		identificacao3.setCpf("111.111.111-13");
		identificacao3.setNomeFantasia("F3");
		identificacao3.setNomePessoaFisica("Pf3");
		identificacao3.setRazaoSocial("Rs3");
		new IdentificacaoServico().criarIdentificacao(identificacao3);
		
		Endereco endereco3 = new Endereco();
		endereco3.setBairro("Bairro 3");
		endereco3.setCep("11111-113");
		endereco3.setCidade("Cidade 3");
		endereco3.setComplemento("Complemento 3");
		endereco3.setNumero(113);
		endereco3.setPais("Brasil");
		endereco3.setReferencia("Referência 3");
		endereco3.setRua("Rua 3");
		endereco3.setUnidadeFederativa(UnidadeFederativa.AMAPA);
		new EnderecoServico().criarEndereco(endereco3);
		
		Contato contato3 = new Contato();
		contato3.setCelular("(11) 9 1111-1113");
		contato3.setEmail("email@clientetres.com");
		contato3.setTelefone("(11) 1111-1113");
		new ContatoServico().criarContato(contato3);
		
		Cliente cliente3 = new Cliente();
		cliente3.setIdentificacao(new IdentificacaoServico().encontrarIdentificacao(12L));
		cliente3.setEndereco(new EnderecoServico().encontrarEndereco(13L));
		cliente3.setContato(new ContatoServico().encotrarContato(14L));
		cliente3.setIdade(27);
		
		assertEquals(15L, new ClienteServico().criarCliente(cliente3));
	}

}

package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import main.java.enumeracao.Setor;
import main.java.enumeracao.SubSetorComercio;
import main.java.enumeracao.UnidadeFederativa;
import main.java.modelo.cliente.Cliente;
import main.java.modelo.compra.Compra;
import main.java.modelo.config.Config;
import main.java.modelo.contato.Contato;
import main.java.modelo.endereco.Endereco;
import main.java.modelo.estoque.comercio.EstoqueComercio;
import main.java.modelo.estoque.manutencao.EstoqueManutencao;
import main.java.modelo.fornecedor.Fornecedor;
import main.java.modelo.identificacao.Identificacao;
import main.java.modelo.mercadoria.Mercadoria;
import main.java.modelo.outro.Outro;
import main.java.modelo.peca.Peca;
import main.java.modelo.produto.Produto;
import main.java.modelo.tecnico.Tecnico;
import main.java.modelo.vendedor.Vendedor;
import main.java.servico.VendedorServico;
import main.java.servico.cliente.ClienteServico;
import main.java.servico.comercio.EstoqueComercioServico;
import main.java.servico.compra.CompraServico;
import main.java.servico.config.ConfigServico;
import main.java.servico.contato.ContatoServico;
import main.java.servico.endereco.EnderecoServico;
import main.java.servico.fornecedor.FornecedorServico;
import main.java.servico.identificacao.IdentificacaoServico;
import main.java.servico.manutencao.EstoqueManutencaoServico;
import main.java.servico.mercadoria.MercadoriaServico;
import main.java.servico.outro.OutroServico;
import main.java.servico.peca.PecaServico;
import main.java.servico.produto.ProdutoServico;
import main.java.servico.tecnico.TecnicoServico;

@TestMethodOrder(OrderAnnotation.class)
class T01Tests {
	
	private Config configComercio;
	private Config configManutencao;
	private Config configHibrido;
	private Identificacao identificacao;
	private Contato contato;
	private Endereco endereco;
	private Fornecedor fornecedor;
	private EstoqueComercio estoqueComercio1;
	private EstoqueManutencao estoqueManutencao;
	private Peca peca1;
	private Peca peca2;
	private Peca peca3;
	private Produto produto1;
	private Produto produto2;
	private Produto produto3;
	private Outro outro1;
	private Outro outro2;
	private Outro outro3;
	private Mercadoria mercadoria1;
	private Mercadoria mercadoria2;
	private Mercadoria mercadoria3;
	private Cliente cliente1;
	private Cliente cliente2;

	@BeforeEach
	void setUp() throws Exception {
		configComercio = new Config();
		configComercio.setSetor(Setor.COMERCIO);
		
		configManutencao = new Config();
		configManutencao.setSetor(Setor.MANUTENCAO_TECNICA);
		
		configHibrido = new Config();
		configHibrido.setSetor(Setor.HIBRIDO);
		
		identificacao = new Identificacao();
		identificacao.setNomeFantasia("Nome Fantasia um");
		identificacao.setRazaoSocial("Razão social um");
		identificacao.setCpf("222.222.222-22");
		identificacao.setCnpj("55.555.555/555-55");
		
		contato = new Contato();
		contato.setCelular("77 (23) 9 1287-2483");
		contato.setTelefone("77 (34) 1346-9865");
		contato.setEmail("email@um.com");
		contato.setSite("www.site.com.br");
		
		endereco = new Endereco();
		endereco.setRua("Rua um");
		endereco.setNumero(537);
		endereco.setComplemento("Casa");
		endereco.setBairro("Bairro um");
		endereco.setCep("99487-367");
		endereco.setReferencia("Referência um");
		endereco.setCidade("Fortaleza");
		endereco.setUnidadeFederativa(UnidadeFederativa.CEARA);
		endereco.setPais("Brasil");
		
		fornecedor = new Fornecedor();
		Identificacao ident3 = new IdentificacaoServico().encontrarIdentificacao(3L);
		Contato cont4 = new ContatoServico().encotrarContato(4L);
		Endereco end5 = new EnderecoServico().encontrarEndereco(5L);
		Set<Endereco> enderecosFornecedor = new HashSet<>();
		enderecosFornecedor.add(end5);
		fornecedor.setIdentificacaoFornecedor(ident3);
		fornecedor.setContatoFornecedor(cont4);
		fornecedor.setEnderecosFornecedor(enderecosFornecedor);
		
		Calendar dataAquisicaoMercadoria1 = Calendar.getInstance();
		dataAquisicaoMercadoria1.set(2021, 6, 15, 11, 39);
		Calendar dataVencimentoMercadoria1 = Calendar.getInstance();
		dataVencimentoMercadoria1.set(2023, 3, 17, 21, 47);
		Set<Fornecedor> fornecedoresMercadoria1 = new HashSet<>();
		fornecedoresMercadoria1.add(new FornecedorServico().encontrarFornecedor(6L));
		mercadoria1 = new Mercadoria(
					"1234444467899", "Arroz", "Arroz parboilizado, pacote de 5 kg", "Primo Rico", 
					new BigDecimal("8.97"), new BigDecimal("9.35"), new BigDecimal("5.12"), dataAquisicaoMercadoria1, 
					dataVencimentoMercadoria1, SubSetorComercio.ALIMENTICIO, 0L, fornecedoresMercadoria1
				);
		
		Calendar dataAquisicaoMercadoria2 = Calendar.getInstance();
		dataAquisicaoMercadoria2.set(2021, 6, 15, 11, 39);
		Calendar dataVencimentoMercadoria2 = Calendar.getInstance();
		dataVencimentoMercadoria2.set(2023, 3, 17, 21, 47);
		Set<Fornecedor> fornecedoresMercadoria2 = new HashSet<>();
		fornecedoresMercadoria2.add(new FornecedorServico().encontrarFornecedor(6L));
		mercadoria2 = new Mercadoria(
				"2314444467899", "Feijão", "Feijão, pacote de 5 kg", "Feijão Nº 1", 
				new BigDecimal("12.97"), new BigDecimal("6.12"), new BigDecimal("6.12"), dataAquisicaoMercadoria2, 
				dataVencimentoMercadoria2, SubSetorComercio.ALIMENTICIO, 0L, fornecedoresMercadoria2
				);
		
		Calendar dataAquisicaoMercadoria3 = Calendar.getInstance();
		dataAquisicaoMercadoria3.set(2021, 6, 15, 11, 39);
		Calendar dataVencimentoMercadoria3 = Calendar.getInstance();
		dataVencimentoMercadoria3.set(2023, 3, 17, 21, 47);
		Set<Fornecedor> fornecedoresMercadoria3 = new HashSet<>();
		fornecedoresMercadoria3.add(new FornecedorServico().encontrarFornecedor(6L));
		mercadoria3 = new Mercadoria(
				"6927444467899", "Margaria", "Margariana de 500 g", "Qualy", 
				new BigDecimal("8.73"), new BigDecimal("3.97"), new BigDecimal("3.12"), dataAquisicaoMercadoria3, 
				dataVencimentoMercadoria3, SubSetorComercio.ALIMENTICIO, 0L, fornecedoresMercadoria3
				);
		
		estoqueManutencao = new EstoqueManutencao();
		Set<Peca> pecas = new HashSet<>();
		peca1 = new Peca();
		peca1.setCodigoPeca("36952687841196");
		peca1.setLocalEstaGuardado("Local um");
		peca1.setNomeDaPeca("Guidão");
		peca1.setDescricao("Guidão de aço reforçado, cor prata");
		peca1.setFabricante("Fabricante 1");
		Set<Fornecedor> fornecedoresPeca1 = new HashSet<>();
		Fornecedor fornecedorPeca1 = new FornecedorServico().encontrarFornecedor(6L);
		fornecedoresPeca1.add(fornecedorPeca1);
		peca1.setFornecedoresPeca(fornecedoresPeca1);
		peca1.setFotoPeca("/fotos/foto04.png");
		peca1.setQuantidadePeca(0L);
		
		peca2 = new Peca();
		peca2.setCodigoPeca("98952687841196");
		peca2.setLocalEstaGuardado("Local dois");
		peca2.setNomeDaPeca("Freio");
		peca2.setDescricao("Freio de aço reforçado, cor preta");
		peca2.setFabricante("Fabricante 2");
		Set<Fornecedor> fornecedoresPeca2 = new HashSet<>();
		Fornecedor fornecedorPeca2 = new FornecedorServico().encontrarFornecedor(6L);
		fornecedoresPeca2.add(fornecedorPeca2);
		peca2.setFornecedoresPeca(fornecedoresPeca2);
		peca2.setFotoPeca("/fotos/foto05.png");
		peca2.setQuantidadePeca(0L);
		
		peca3 = new Peca();
		peca3.setCodigoPeca("36982687841137");
		peca3.setLocalEstaGuardado("Local três");
		peca3.setNomeDaPeca("Sela");
		peca3.setDescricao("Sela de borracha, cor preta");
		peca3.setFabricante("Fabricante 3");
		Set<Fornecedor> fornecedoresPeca3 = new HashSet<>();
		Fornecedor fornecedorPeca3 = new FornecedorServico().encontrarFornecedor(6L);
		fornecedoresPeca3.add(fornecedorPeca3);
		peca3.setFornecedoresPeca(fornecedoresPeca3);
		peca3.setFotoPeca("/fotos/foto06.png");
		peca3.setQuantidadePeca(0L);
		
		pecas.add(peca1);
		pecas.add(peca2);
		pecas.add(peca3);
		
		produto1 = new Produto();
		produto1.setIndentificadorProduto("Identificador um");
		produto1.setLocalEstaGuardado("Local um");
		produto1.setNomeDoProduto("Produto um");
		produto1.setDescricao("Descrição um");
		produto1.setFabricante("Fabricante um");
		Set<Fornecedor> fornecedoresProduto1 = new HashSet<>();
		Fornecedor fornec1 = new FornecedorServico().encontrarFornecedor(6L);
		fornecedoresProduto1.add(fornec1);
		produto1.setFornecedoresProduto(fornecedoresProduto1);
		produto1.setFotoProduto("/fotos/foto07.png");
		produto1.setPrecoAvista(new BigDecimal("18.37"));
		produto1.setPrecoParcelado(new BigDecimal("0"));
		produto1.setQuantidadeProduto(0L);
		
		produto2 = new Produto();
		produto2.setIndentificadorProduto("Identificador dois");
		produto2.setLocalEstaGuardado("Local dois");
		produto2.setNomeDoProduto("Produto dois");
		produto2.setDescricao("Descrição dois");
		produto2.setFabricante("Fabricante dois");
		Set<Fornecedor> fornecedoresProduto2 = new HashSet<>();
		Fornecedor fornec2 = new FornecedorServico().encontrarFornecedor(6L);
		fornecedoresProduto2.add(fornec2);
		produto2.setFornecedoresProduto(fornecedoresProduto2);
		produto2.setFotoProduto("/fotos/foto08.png");
		produto2.setPrecoAvista(new BigDecimal("19.37"));
		produto2.setPrecoParcelado(new BigDecimal("0"));
		produto2.setQuantidadeProduto(0L);
		
		produto3 = new Produto();
		produto3.setIndentificadorProduto("Identificador três");
		produto3.setLocalEstaGuardado("Local três");
		produto3.setNomeDoProduto("Produto três");
		produto3.setDescricao("Descrição três");
		produto3.setFabricante("Fabricante três");
		Set<Fornecedor> fornecedoresProduto3 = new HashSet<>();
		Fornecedor fornec3 = new FornecedorServico().encontrarFornecedor(6L);
		fornecedoresProduto3.add(fornec3);
		produto3.setFornecedoresProduto(fornecedoresProduto3);
		produto3.setFotoProduto("/fotos/foto09.png");
		produto3.setPrecoAvista(new BigDecimal("20.45"));
		produto3.setPrecoParcelado(new BigDecimal("0"));
		produto3.setQuantidadeProduto(0L);
		
		estoqueManutencao.setPecas(pecas);
		
		Set<Produto> produtos = new HashSet<>();
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		estoqueManutencao.setProdutos(produtos);
		
		Set<Fornecedor> fornecedoresOutros1 = new HashSet<>();
		Fornecedor fornedorOutro1 = new FornecedorServico().encontrarFornecedor(6L);
		fornecedoresOutros1.add(fornedorOutro1);
		outro1 = new Outro(
					"Indentificador um", "Local um", "Nome um", "Descrição um", "Fabricante um", 
					new BigDecimal("39.41"), new BigDecimal("0"), fornecedoresOutros1, "/fotos/foto01.png"
				);
		outro1.setQuantidadeOutro(0L);
		
		Set<Fornecedor> fornecedoresOutros2 = new HashSet<>();
		Fornecedor fornedorOutro2 = new FornecedorServico().encontrarFornecedor(6L);
		fornecedoresOutros2.add(fornedorOutro2);
		outro2 = new Outro(
					"Indentificador dois", "Local dois", "Nome dois", "Descrição dois", "Fabricante dois", 
					new BigDecimal("49.41"), new BigDecimal("0"), fornecedoresOutros2, "/fotos/foto02.png"
				);
		outro2.setQuantidadeOutro(0L);
		
		Set<Fornecedor> fornecedoresOutros3 = new HashSet<>();
		Fornecedor fornedorOutro3 = new FornecedorServico().encontrarFornecedor(6L);
		fornecedoresOutros3.add(fornedorOutro3);
		outro3 = new Outro(
					"Indentificador Três", "Local Três", "Nome Três", "Descrição Três", "Fabricante Três", 
					new BigDecimal("59.41"), new BigDecimal("0"), fornecedoresOutros3, "/fotos/foto03.png"
				);
		outro3.setQuantidadeOutro(0L);
		
		Set<Outro> outros = new HashSet<>();
		outros.add(outro1);
		outros.add(outro2);
		outros.add(outro3);
		estoqueManutencao.setOutros(outros);
		
	}

	@Test
	@Order(1)
	void testCriarComercio() {
		assertEquals(1L, new ConfigServico().criarConfig(configComercio));
	}
	
	@Test
	@Order(2)
	void testCriarManutencao() {
		assertEquals(2L, new ConfigServico().criarConfig(configManutencao));
	}
	
	@Test
	@Order(3)
	void testCriarIdentificacao() {
		assertEquals(3L, new IdentificacaoServico().criarIdentificacao(identificacao));
	}
	
	@Test
	@Order(4)
	void testCriarContato() {
		assertEquals(4L, new ContatoServico().criarContato(contato));
	}
	
	@Test
	@Order(5)
	void testCriarEndereco() {
		assertEquals(5L, new EnderecoServico().criarEndereco(endereco));
	}
	
	@Test
	@Order(6)
	void testCriarFornecedor() {
		assertEquals(6L, new FornecedorServico().criarFornecedor(fornecedor));
	}
	
	@Test
	@Order(7)
	void testCriarEstoqueComercio() {
		
		assertEquals(7L, new MercadoriaServico().criarMercadoria(mercadoria1));
		assertEquals(8L, new MercadoriaServico().criarMercadoria(mercadoria2));
		assertEquals(9L, new MercadoriaServico().criarMercadoria(mercadoria3));
		
		estoqueComercio1 = new EstoqueComercio();
		Set<Mercadoria> mercadorias = new HashSet<>();
		Mercadoria merc1 = new MercadoriaServico().encontrarMercadoria(7L);
		Mercadoria merc2 = new MercadoriaServico().encontrarMercadoria(8L);
		Mercadoria merc3 = new MercadoriaServico().encontrarMercadoria(9L);
		mercadorias.add(merc1);
		mercadorias.add(merc2);
		mercadorias.add(merc3);
		estoqueComercio1.setMercadorias(mercadorias);
		
		Long ecs1 = null;
		Config configuracao = new ConfigServico().encontrarConfig(1L);
		if (configuracao.getSetor() == Setor.COMERCIO) {
			ecs1 = (Long) new EstoqueComercioServico().criarEstoqueMercadoriaComercio(estoqueComercio1);// Item 1 cadastrado no estoque
		}
		assertEquals(10L, ecs1);
	}
	
	
	@Test
	@Order(8)
	void testCriarHibrido() {
		assertEquals(11L, new ConfigServico().criarConfig(configHibrido));
	}
	
	
	@Test
	@Order(9)
	void testCriarEstoqueManutencao() {
		assertEquals(12L, new PecaServico().criarPeca(peca1));
		assertEquals(13L, new PecaServico().criarPeca(peca2));
		assertEquals(14L, new PecaServico().criarPeca(peca3));
		
		assertEquals(15L, new ProdutoServico().criarProduto(produto1));
		assertEquals(16L, new ProdutoServico().criarProduto(produto2));
		assertEquals(17L, new ProdutoServico().criarProduto(produto3));
		
		assertEquals(18L, new OutroServico().criarOutro(outro1));
		assertEquals(19L, new OutroServico().criarOutro(outro2));
		assertEquals(20L, new OutroServico().criarOutro(outro3));
		
		Long em1 = null;
		Config configuracao = new ConfigServico().encontrarConfig(2L);
		if (configuracao.getSetor() == Setor.MANUTENCAO_TECNICA) {
			em1 = (Long) new EstoqueManutencaoServico().criarEstoqueManutencao(estoqueManutencao);
		}
		assertEquals(21L, em1);
	}


	@Test
	@Order(10)
	void testCriarCliente() {
		Identificacao identCliente1 = new Identificacao();
		identCliente1.setNomePessoaFisica("Pessoa um");
		identCliente1.setCpf("935.686.792-18");
		new IdentificacaoServico().criarIdentificacao(identCliente1);
		
		Identificacao identCliente2 = new Identificacao();
		identCliente2.setNomePessoaFisica("Pessoa dois");
		identCliente2.setCpf("375.686.799-37");
		new IdentificacaoServico().criarIdentificacao(identCliente2);
		
		Endereco enderecoCliente1 = new Endereco();
		enderecoCliente1.setRua("Rua cliente um");
		enderecoCliente1.setNumero(975);
		enderecoCliente1.setComplemento("Apartamento");
		enderecoCliente1.setCep("98738-364");
		enderecoCliente1.setReferencia("Centro");
		enderecoCliente1.setCidade("Brasilia");
		enderecoCliente1.setUnidadeFederativa(UnidadeFederativa.DISTRITO_FEDERAL);
		enderecoCliente1.setPais("Brasil");
		new EnderecoServico().criarEndereco(enderecoCliente1);
		
		Endereco enderecoCliente2 = new Endereco();
		enderecoCliente2.setRua("Rua cliente dois");
		enderecoCliente2.setNumero(386);
		enderecoCliente2.setComplemento("Casa");
		enderecoCliente2.setCep("96738-364");
		enderecoCliente2.setReferencia("Centro");
		enderecoCliente2.setCidade("Cidade dois");
		enderecoCliente2.setUnidadeFederativa(UnidadeFederativa.ALAGOAS);
		enderecoCliente2.setPais("Brasil");
		new EnderecoServico().criarEndereco(enderecoCliente2);
		
		Contato contatoCliente1 = new Contato();
		contatoCliente1.setCelular("+55 (37) 9 1834-6972");
		contatoCliente1.setTelefone("(32) 9836-4896");
		contatoCliente1.setEmail("email@clienteum.com");
		new ContatoServico().criarContato(contatoCliente1);
		
		Contato contatoCliente2 = new Contato();
		contatoCliente2.setCelular("+55 (94) 9 2734-6917");
		contatoCliente2.setTelefone("(58) 7636-4884");
		contatoCliente2.setEmail("email@clientedois.com");
		new ContatoServico().criarContato(contatoCliente2);
		
		cliente1 = new Cliente();
		cliente1.setIdentificacao(new IdentificacaoServico().encontrarIdentificacao(22L));
		cliente1.setEndereco(new EnderecoServico().encontrarEndereco(24L));
		cliente1.setContato(new ContatoServico().encotrarContato(26L));
		
		cliente2 = new Cliente();
		cliente2.setIdentificacao(new IdentificacaoServico().encontrarIdentificacao(23L));
		cliente2.setEndereco(new EnderecoServico().encontrarEndereco(25L));
		cliente2.setContato(new ContatoServico().encotrarContato(27L));
		
		assertEquals(28L, new ClienteServico().criarCliente(cliente1));
		assertEquals(29L, new ClienteServico().criarCliente(cliente2));
	}
	
	@Test
	@Order(11)
	void testCriarTecnico() {
		Identificacao identTecnico1 = new Identificacao();
		identTecnico1.setNomePessoaFisica("Técnico um");
		identTecnico1.setCpf("983.686.792-18");
		new IdentificacaoServico().criarIdentificacao(identTecnico1);
		
		Identificacao identTecnico2 = new Identificacao();
		identTecnico2.setNomePessoaFisica("Técnico dois");
		identTecnico2.setCpf("487.686.799-37");
		new IdentificacaoServico().criarIdentificacao(identTecnico2);
		
		Endereco enderecoTecnico1 = new Endereco();
		enderecoTecnico1.setRua("Rua Técnico um");
		enderecoTecnico1.setNumero(167);
		enderecoTecnico1.setComplemento("Apartamento");
		enderecoTecnico1.setCep("98776-364");
		enderecoTecnico1.setReferencia("Centro");
		enderecoTecnico1.setCidade("Brasilia");
		enderecoTecnico1.setUnidadeFederativa(UnidadeFederativa.DISTRITO_FEDERAL);
		enderecoTecnico1.setPais("Brasil");
		new EnderecoServico().criarEndereco(enderecoTecnico1);
		
		Endereco enderecoTecnico2 = new Endereco();
		enderecoTecnico2.setRua("Rua Técnio dois");
		enderecoTecnico2.setNumero(349);
		enderecoTecnico2.setComplemento("Casa");
		enderecoTecnico2.setCep("769348-364");
		enderecoTecnico2.setReferencia("Centro");
		enderecoTecnico2.setCidade("Cidade dois");
		enderecoTecnico2.setUnidadeFederativa(UnidadeFederativa.ALAGOAS);
		enderecoTecnico2.setPais("Brasil");
		new EnderecoServico().criarEndereco(enderecoTecnico2);
		
		Contato contatoTecnico1 = new Contato();
		contatoTecnico1.setCelular("+55 (83) 9 8134-6972");
		contatoTecnico1.setTelefone("(73) 3736-4896");
		contatoTecnico1.setEmail("email@tecnicoum.com");
		new ContatoServico().criarContato(contatoTecnico1);
		
		Contato contatoTecnico2 = new Contato();
		contatoTecnico2.setCelular("+55 (38) 9 3734-6917");
		contatoTecnico2.setTelefone("(37) 3936-4884");
		contatoTecnico2.setEmail("email@tecnicodois.com");
		new ContatoServico().criarContato(contatoTecnico2);
		
		Tecnico tecnico1 = new Tecnico();
		tecnico1.setIdentificacao(new IdentificacaoServico().encontrarIdentificacao(30L));
		tecnico1.setEndereco(new EnderecoServico().encontrarEndereco(32L));
		tecnico1.setContato(new ContatoServico().encotrarContato(34L));
		tecnico1.setAreaEspecializacao("Área um");
		
		Tecnico tecnico2 = new Tecnico();
		tecnico2.setIdentificacao(new IdentificacaoServico().encontrarIdentificacao(31L));
		tecnico2.setEndereco(new EnderecoServico().encontrarEndereco(33L));
		tecnico2.setContato(new ContatoServico().encotrarContato(35L));
		tecnico2.setAreaEspecializacao("Área dois");
		
		assertEquals(36L, new TecnicoServico().criarTecnico(tecnico1));
		assertEquals(37L, new TecnicoServico().criarTecnico(tecnico2));
	}
	
	@Test
	@Order(12)
	void testeCriarVendedor() {
		Identificacao identVendedor1 = new Identificacao();
		identVendedor1.setNomePessoaFisica("Vendedor um");
		identVendedor1.setCpf("983.498..792-18");
		new IdentificacaoServico().criarIdentificacao(identVendedor1);
		
		Identificacao identVendedor2 = new Identificacao();
		identVendedor2.setNomePessoaFisica("Vendedor dois");
		identVendedor2.setCpf("327.598.799-37");
		new IdentificacaoServico().criarIdentificacao(identVendedor2);
		
		Endereco enderecoVendedor1 = new Endereco();
		enderecoVendedor1.setRua("Rua Vendedor um");
		enderecoVendedor1.setNumero(715);
		enderecoVendedor1.setComplemento("Apartamento");
		enderecoVendedor1.setCep("68728-364");
		enderecoVendedor1.setReferencia("Centro");
		enderecoVendedor1.setCidade("Brasilia");
		enderecoVendedor1.setUnidadeFederativa(UnidadeFederativa.DISTRITO_FEDERAL);
		enderecoVendedor1.setPais("Brasil");
		new EnderecoServico().criarEndereco(enderecoVendedor1);
		
		Endereco enderecoVendedor2 = new Endereco();
		enderecoVendedor2.setRua("Rua Vendedor dois");
		enderecoVendedor2.setNumero(186);
		enderecoVendedor2.setComplemento("Casa");
		enderecoVendedor2.setCep("43286-364");
		enderecoVendedor2.setReferencia("Centro");
		enderecoVendedor2.setCidade("Cidade dois");
		enderecoVendedor2.setUnidadeFederativa(UnidadeFederativa.ALAGOAS);
		enderecoVendedor2.setPais("Brasil");
		new EnderecoServico().criarEndereco(enderecoVendedor2);
		
		Contato contatoVendedor1 = new Contato();
		contatoVendedor1.setCelular("+55 (27) 9 6484-6972");
		contatoVendedor1.setTelefone("(78) 8276-4896");
		contatoVendedor1.setEmail("email@vendedorum.com");
		new ContatoServico().criarContato(contatoVendedor1);
		
		Contato contatoVendedor2 = new Contato();
		contatoVendedor2.setCelular("+55 (43) 9 4934-6917");
		contatoVendedor2.setTelefone("(11) 3576-4884");
		contatoVendedor2.setEmail("email@vendedordois.com");
		new ContatoServico().criarContato(contatoVendedor2);
		
		Vendedor vendedor1 = new Vendedor();
		vendedor1.setIdentificacao(new IdentificacaoServico().encontrarIdentificacao(38L));
		vendedor1.setEndereco(new EnderecoServico().encontrarEndereco(40L));
		vendedor1.setContato(new ContatoServico().encotrarContato(42L));
		
		Vendedor vendedor2 = new Vendedor();
		vendedor2.setIdentificacao(new IdentificacaoServico().encontrarIdentificacao(39L));
		vendedor2.setEndereco(new EnderecoServico().encontrarEndereco(41L));
		vendedor2.setContato(new ContatoServico().encotrarContato(43L));
		
		assertEquals(44L, new VendedorServico().criarVendedor(vendedor1));
		assertEquals(45L, new VendedorServico().criarVendedor(vendedor2));
	}
	
	@Test
	@Order(13)
	void testeCriarCompra() {
		Config configuracaoCompraComercio = new ConfigServico().encontrarConfig(1L);
		if (configuracaoCompraComercio.getSetor() == Setor.COMERCIO) {
			Calendar dataCompra = Calendar.getInstance();
			dataCompra.set(2021, 03, 21, 16, 33);
			
			Fornecedor fornecedorCompra = new FornecedorServico().encontrarFornecedor(6L);
			
			List<Long> idMercadorias = new ArrayList<>();
			idMercadorias.add(7L);
			idMercadorias.add(8L);
			idMercadorias.add(9L);
			
			List<Long> quantidades = new ArrayList<>();
			quantidades.add(35L);
			quantidades.add(18L);
			quantidades.add(48L);
			
			Set<Mercadoria> mercadorias = new MercadoriaServico().encontrarTodasMercadorias();
			
			for (Mercadoria mercadoria : mercadorias) {
				for (int i = 0; i < idMercadorias.size(); i++) {
					for (int j = 0; j < quantidades.size(); j++) {
						if (i == j) {
							// idMercadorias.size() - (idMercadorias.size() - i)
							if (mercadoria.getIdMercadoria().equals( idMercadorias.get(idMercadorias.size() - (idMercadorias.size() - i)) )) {
								mercadoria.setQuantidadeMercadoriaEstoque( mercadoria.getQuantidadeMercadoriaEstoque() + quantidades.get(quantidades.size() - (quantidades.size() - j)) );
								// Atualizar mercadoria
								System.out.println();
								System.out.println("Status atualização de mercadoria: "+new MercadoriaServico().atualizarMercadoria(mercadoria));
							}
						}
					}
				}
			}
			
			Compra compra = new Compra(dataCompra, fornecedorCompra, mercadorias);
			assertEquals(46L, new CompraServico().criarCompra(compra));
		}
	}

}
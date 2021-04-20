package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import main.java.enumeracao.Setor;
import main.java.enumeracao.SubSetorComercio;
import main.java.enumeracao.UnidadeFederativa;
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
import main.java.servico.comercio.EstoqueComercioServico;
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
		mercadorias.add(merc1 );
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

}

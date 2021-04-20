package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
import main.java.modelo.peca.Peca;
import main.java.modelo.produto.Produto;
import main.java.servico.comercio.EstoqueComercioServico;
import main.java.servico.config.ConfigServico;
import main.java.servico.contato.ContatoServico;
import main.java.servico.endereco.EnderecoServico;
import main.java.servico.fornecedor.FornecedorServico;
import main.java.servico.identificacao.IdentificacaoServico;
import main.java.servico.manutencao.EstoqueManutencaoServico;
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
	private EstoqueComercio estoqueComercio2;
	private EstoqueManutencao estoqueManutencao;
	private Peca peca1;
	private Peca peca2;
	private Peca peca3;
	private Produto produto1;
	private Produto produto2;
	private Produto produto3;

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
		
		estoqueComercio1 = new EstoqueComercio();// Mercadoria 1
		estoqueComercio1.setCodigoBarraMercadoria("1234444467899");
		estoqueComercio1.setNomeMercadoria("Arroz");
		estoqueComercio1.setDescricaoCaracteristicasMercadoria("Arroz parboilizado, pacote de 5 kg");
		estoqueComercio1.setNomeFabricanteMercadoria("Primo Rico");
		estoqueComercio1.setPrecoMercadoriaComprada(new BigDecimal("8.97"));
		estoqueComercio1.setPrecoVistaMercadoria(new BigDecimal("9.35"));
		estoqueComercio1.setPrecoParceladoMercadoria(new BigDecimal("5.12"));
		Calendar dataAquisicaoMercadoria1 = Calendar.getInstance();
		dataAquisicaoMercadoria1.set(2021, 6, 15, 11, 39);
		Calendar dataVencimentoMercadoria1 = Calendar.getInstance();
		dataVencimentoMercadoria1.set(2023, 3, 17, 21, 47);
		estoqueComercio1.setDataAquisicaoMercadoria(dataAquisicaoMercadoria1);
		estoqueComercio1.setDataVencimentoMercadoria(dataVencimentoMercadoria1);
		estoqueComercio1.setSubSetorComercio(SubSetorComercio.ALIMENTICIO);
		estoqueComercio1.setQuantidadeMercadoriaEstoque(0L);// A quantidade de mercadorias inicial é 0
		Set<Fornecedor> fornecedoresMercadoria1 = new HashSet<>();
		fornecedoresMercadoria1.add(new FornecedorServico().encontrarFornecedor(6L));
		estoqueComercio1.setFornecedoresMercadoria(fornecedoresMercadoria1);
		
		estoqueComercio2 = new EstoqueComercio();// Mercadoria 2
		estoqueComercio2.setCodigoBarraMercadoria("2314444467899");
		estoqueComercio2.setNomeMercadoria("Feijão");
		estoqueComercio2.setDescricaoCaracteristicasMercadoria("Feijão, pacote de 5 kg");
		estoqueComercio2.setNomeFabricanteMercadoria("Feijão Nº 1");
		estoqueComercio2.setPrecoMercadoriaComprada(new BigDecimal("12.97"));
		estoqueComercio2.setPrecoVistaMercadoria(new BigDecimal("15.35"));
		estoqueComercio2.setPrecoParceladoMercadoria(new BigDecimal("6.12"));
		Calendar dataAquisicaoMercadoria2 = Calendar.getInstance();
		dataAquisicaoMercadoria2.set(2021, 6, 15, 11, 39);
		Calendar dataVencimentoMercadoria2 = Calendar.getInstance();
		dataVencimentoMercadoria1.set(2023, 3, 17, 21, 47);
		estoqueComercio2.setDataAquisicaoMercadoria(dataAquisicaoMercadoria2);
		estoqueComercio2.setDataVencimentoMercadoria(dataVencimentoMercadoria2);
		estoqueComercio2.setSubSetorComercio(SubSetorComercio.ALIMENTICIO);
		estoqueComercio2.setQuantidadeMercadoriaEstoque(0L);// A quantidade de mercadorias inicial é 0
		Set<Fornecedor> fornecedoresMercadoria2 = new HashSet<>();
		fornecedoresMercadoria2.add(new FornecedorServico().encontrarFornecedor(6L));
		estoqueComercio2.setFornecedoresMercadoria(fornecedoresMercadoria2);
		
		estoqueManutencao = new EstoqueManutencao();
		Map<Integer, Peca> pecas = new HashMap<>();
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
		
		pecas.put(0, peca1);
		pecas.put(0, peca2);
		pecas.put(0, peca3);
		
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
		
		estoqueManutencao.setPecas(pecas);
		Map<Integer, Produto> produtos = new HashMap<>();
		produtos.put(0, produto1);
		produtos.put(0, produto2);
		produtos.put(0, produto3);
		estoqueManutencao.setProdutos(produtos);
		
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
		Long ecs1 = null;
		Long ecs2 = null;
		Config configuracao = new ConfigServico().encontrarConfig(1L);
		if (configuracao.getSetor() == Setor.COMERCIO) {
			ecs1 = (Long) new EstoqueComercioServico().criarEstoqueMercadoriaComercio(estoqueComercio1);// Item 1 cadastrado no estoque
			ecs2 = (Long) new EstoqueComercioServico().criarEstoqueMercadoriaComercio(estoqueComercio2);// Item 2 cadastrado no estoque
		}
		assertEquals(7L, ecs1);
		assertEquals(8L, ecs2);
	}
	
	
	@Test
	@Order(8)
	void testCriarHibrido() {
		assertEquals(9L, new ConfigServico().criarConfig(configHibrido));
	}
	
	@Test
	@Order(9)
	void testCriarEstoqueManutencao() {
		assertEquals(10L, new PecaServico().criarPeca(peca1));
		assertEquals(11L, new PecaServico().criarPeca(peca2));
		assertEquals(12L, new PecaServico().criarPeca(peca3));
		
		assertEquals(13L, new ProdutoServico().criarProduto(produto1));
		assertEquals(14L, new ProdutoServico().criarProduto(produto2));
		assertEquals(15L, new ProdutoServico().criarProduto(produto3));
		
		Long em1 = null;
		Config configuracao = new ConfigServico().encontrarConfig(2L);
		if (configuracao.getSetor() == Setor.MANUTENCAO_TECNICA) {
			em1 = (Long) new EstoqueManutencaoServico().criarEstoqueManutencao(estoqueManutencao);
		}
		assertEquals(16L, em1);
	}

}

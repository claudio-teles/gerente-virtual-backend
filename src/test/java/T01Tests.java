package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import main.java.modelo.fornecedor.Fornecedor;
import main.java.modelo.identificacao.Identificacao;
import main.java.servico.comercio.EstoqueComercioServico;
import main.java.servico.config.ConfigServico;
import main.java.servico.contato.ContatoServico;
import main.java.servico.endereco.EnderecoServico;
import main.java.servico.fornecedor.FornecedorServico;
import main.java.servico.identificacao.IdentificacaoServico;

@TestMethodOrder(OrderAnnotation.class)
class T01Tests {
	
	private Config configComercio;
	private Config configManutencao;
	private Identificacao identificacao;
	private Contato contato;
	private Endereco endereco;
	private Fornecedor fornecedor;
	private EstoqueComercio estoqueComercio1;
	private EstoqueComercio estoqueComercio2;
	private EstoqueComercio estoqueComercio3;

	@BeforeEach
	void setUp() throws Exception {
		configComercio = new Config();
		configComercio.setSetor(Setor.COMERCIO);
		
		configManutencao = new Config();
		configManutencao.setSetor(Setor.MANUTENCAO_TECNICA);
		
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
		List<Endereco> enderecosFornecedor = new ArrayList<>();
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
		estoqueComercio1.setQuantidadeMercadoriaEstoque(60L);
		List<Fornecedor> fornecedoresMercadoria1 = new ArrayList<>();
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
		estoqueComercio2.setQuantidadeMercadoriaEstoque(40L);
		List<Fornecedor> fornecedoresMercadoria2 = new ArrayList<>();
		fornecedoresMercadoria2.add(new FornecedorServico().encontrarFornecedor(6L));
		estoqueComercio2.setFornecedoresMercadoria(fornecedoresMercadoria2);
		
		estoqueComercio3 = new EstoqueComercio();// Mercadoria 3
		estoqueComercio3.setCodigoBarraMercadoria("3124444467899");
		estoqueComercio3.setNomeMercadoria("Margarina");
		estoqueComercio3.setDescricaoCaracteristicasMercadoria("Margarina, pote de 500 gramas");
		estoqueComercio3.setNomeFabricanteMercadoria("Qualy");
		estoqueComercio3.setPrecoMercadoriaComprada(new BigDecimal("4.89"));
		estoqueComercio3.setPrecoVistaMercadoria(new BigDecimal("5.31"));
		estoqueComercio3.setPrecoParceladoMercadoria(new BigDecimal("2.47"));
		Calendar dataAquisicaoMercadoria3 = Calendar.getInstance();
		dataAquisicaoMercadoria3.set(2021, 8, 27, 7, 12);
		Calendar dataVencimentoMercadoria3 = Calendar.getInstance();
		dataVencimentoMercadoria1.set(2023, 3, 17, 21, 47);
		estoqueComercio3.setDataAquisicaoMercadoria(dataAquisicaoMercadoria3);
		estoqueComercio3.setDataVencimentoMercadoria(dataVencimentoMercadoria3);
		estoqueComercio3.setSubSetorComercio(SubSetorComercio.ALIMENTICIO);
		estoqueComercio3.setQuantidadeMercadoriaEstoque(75L);
		List<Fornecedor> fornecedoresMercadoria3 = new ArrayList<>();
		fornecedoresMercadoria3.add(new FornecedorServico().encontrarFornecedor(6L));
		estoqueComercio3.setFornecedoresMercadoria(fornecedoresMercadoria3);
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
		Long ecs3 = null;
		Config configuracao = new ConfigServico().encontrarConfig(1L);
		if (configuracao.getSetor() == Setor.COMERCIO) {
			ecs1 = (Long) new EstoqueComercioServico().criarEstoqueMercadoriaComercio(estoqueComercio1);
			ecs2 = (Long) new EstoqueComercioServico().criarEstoqueMercadoriaComercio(estoqueComercio2);
			ecs3 = (Long) new EstoqueComercioServico().criarEstoqueMercadoriaComercio(estoqueComercio3);
		}
		assertEquals(7L, ecs1);
		assertEquals(8L, ecs2);
		assertEquals(9L, ecs3);
	}

}

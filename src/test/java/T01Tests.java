package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import main.java.enumeracao.Setor;
import main.java.enumeracao.SubSetorComercio;
import main.java.enumeracao.SubSetorManutencao;
import main.java.modelo.config.Config;
import main.java.modelo.identificacao.Identificacao;
import main.java.servico.config.ConfigServico;
import main.java.servico.identificacao.IdentificacaoServico;

@TestMethodOrder(OrderAnnotation.class)
class T01Tests {
	
	private Config configComercio;
	private Config configManutencao;
	private Identificacao identificacao;

	@BeforeEach
	void setUp() throws Exception {
		configComercio = new Config();
		configComercio.setSetor(Setor.COMERCIO);
		configComercio.setSubSetorComercio(SubSetorComercio.ALIMENTICIO);
		
		configManutencao = new Config();
		configManutencao.setSetor(Setor.MANUTENCAO_TECNICA);
		configManutencao.setSubSetorManutencao(SubSetorManutencao.INFORMATICA);
		
		identificacao = new Identificacao();
		identificacao.setNomeFantasia("Nome Fantasia um");
		identificacao.setRazaoSocial("Razão social um");
		identificacao.setCpf("222.222.222-22");
		identificacao.setCnpj("55.555.555/555-55");
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

}

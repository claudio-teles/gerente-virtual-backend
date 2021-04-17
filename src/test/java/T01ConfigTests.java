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
import main.modelo.config.Config;
import main.servico.config.ConfigServico;

@TestMethodOrder(OrderAnnotation.class)
class T01ConfigTests {
	
	private Config configComercio;
	private Config configManutencao;

	@BeforeEach
	void setUp() throws Exception {
		configComercio = new Config();
		configComercio.setSetor(Setor.COMERCIO);
		configComercio.setSubSetorComercio(SubSetorComercio.ALIMENTICIO);
		
		configManutencao = new Config();
		configManutencao.setSetor(Setor.MANUTENCAO_TECNICA);
		configManutencao.setSubSetorManutencao(SubSetorManutencao.INFORMATICA);
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

}

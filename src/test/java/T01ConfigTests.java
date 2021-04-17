package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enumeracao.Setor;
import enumeracao.SubSetorComercio;
import enumeracao.SubSetorManutencao;
import modelo.config.Config;
import servico.config.ConfigServico;

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
	void test01Comercio() {
		assertEquals(1L, new ConfigServico().criarConfig(configComercio));
	}
	
	@Test
	void test02Manutencao() {
		assertEquals(1L, new ConfigServico().criarConfig(configManutencao));
	}

}

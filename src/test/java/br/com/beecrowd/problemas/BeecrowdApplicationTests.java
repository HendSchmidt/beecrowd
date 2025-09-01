package br.com.beecrowd.problemas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BeecrowdApplicationTests {

	@Test
	void contextLoads(ApplicationContext context) {
		// Verifica se o contexto do Spring foi carregado com sucesso
		// Se este teste passar, significa que a aplicação inicializou sem exceções.
		assertThat(context).isNotNull();
	}


}

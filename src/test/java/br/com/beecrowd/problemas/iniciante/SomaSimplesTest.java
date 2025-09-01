package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.impl.SomaSimples;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Soma simples")
public class SomaSimplesTest {
	private static final String SOMA_SIMPLES_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.SomaSimplesArrange";
	private static SomaSimples test;

	@BeforeAll
	static void setup(){
		test = new SomaSimples();
	}

	@ParameterizedTest(name = "Arranjo {index} : {0} + {1} = {2}")
	@MethodSource(SOMA_SIMPLES_ARRANGE + "#somaDeDoisNumeros")
	@DisplayName("Deve retornar mensagem correta.")
	void deveRetornarMensagemCorreta(int a, int b, String esperado){
		System.setIn(getByteArrayInputStream(a, b));

		String resultado = test.execute();

		assertAll("Soma Inputs",
				() -> assertEquals(esperado, resultado, "Resultado deveria ser igual ao esperado."));
	}

	private static ByteArrayInputStream getByteArrayInputStream(int a, int b) {
		return new ByteArrayInputStream("""
				%d
				%d
				""".formatted(a, b).getBytes());
	}
}

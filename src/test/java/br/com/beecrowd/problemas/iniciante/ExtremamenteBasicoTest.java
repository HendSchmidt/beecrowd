package br.com.beecrowd.problemas.iniciante;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Extremamente Básico")
class ExtremamenteBasicoTest {
	public static final String EXTREMAMENTE_BASICO_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.ExtremamenteBasicoArrange";
	private static ExtremamenteBasico test;

	@BeforeAll
	static void setup(){
		test = new ExtremamenteBasico();
	}

	@ParameterizedTest(name = "Arranjo {index} : {0} + {1} = {2}")
	@MethodSource(EXTREMAMENTE_BASICO_ARRANGE + "#somaValida")
	@DisplayName("Deve somar com dados validos.")
	void deveSomarComDadosValidos(int a, int b, int esperado){
		int resultado = test.soma(a, b);

		assertAll("Soma",
				() -> assertEquals(esperado, resultado, "Resultado deveria ser igual ao esperado."));
	}

	@ParameterizedTest(name = "Arranjo {index} : {0} + {1} = {2}")
	@MethodSource(EXTREMAMENTE_BASICO_ARRANGE + "#somaValida")
	@DisplayName("Deve ler entrada e somar.")
	void deveLerEntradaSomar(int a, int b, int esperado){
		System.setIn(getByteArrayInputStream(a, b));
		int resultado = test.somaInputs();

		assertAll("Soma Inputs",
				() -> assertEquals(esperado, resultado, "Resultado deveria ser igual ao esperado."));
	}

	@ParameterizedTest(name = "Arranjo {index} : {0} + {1} = {2}")
	@MethodSource(EXTREMAMENTE_BASICO_ARRANGE + "#mensagemValida")
	@DisplayName("Deve retornar mensagem correta.")
	void deveRetornarMensagemCorreta(int a, int b, String esperado){
		System.setIn(getByteArrayInputStream(a, b));

		String resultado = test.retornaMensagem();

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

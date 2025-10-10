package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.impl.CalculoSimples;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Calculo simples")
class CalculoSimplesTest {
	private static final String CALCULO_SIMPLES_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.CalculoSimplesArrange";
	private static final String METHOD_SOURCE_ARRANGE_CORRETO = CALCULO_SIMPLES_ARRANGE + "#arrangeCorreto";

	@ParameterizedTest(name = "Arranjo {index} : {0} -> {2}")
	@MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
	@DisplayName("Deve retornar o calculo do valot total das peças corretamente.")
	void deveRetornarCalculoTotalDoValorDePecas(String input, String resultadoEsperado){
		var calculaValorTotal = new CalculoSimples();
		System.setIn(setInput(input));
		assertAll("Valor total", () -> assertEquals(resultadoEsperado, calculaValorTotal.execute()));
	}

	private static ByteArrayInputStream setInput(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}
}

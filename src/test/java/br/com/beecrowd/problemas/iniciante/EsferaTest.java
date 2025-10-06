package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.arrange.EsferaArrange;
import br.com.beecrowd.problemas.iniciante.impl.Esfera;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Esfera")
public class EsferaTest {
	private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.EsferaArrange";
	private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

	@ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
	@MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
	@DisplayName("Deve retornar o calculo do valor total das peças corretamente.")
	void deveRetornarCalculoDoVolumeDaEsfera(Double a, String resultadoEsperado){
		var calculaVolumeEsfera = new Esfera();
		System.setIn(setInput(a));
		assertAll("Valor total", () -> assertEquals(resultadoEsperado, calculaVolumeEsfera.execute()));
	}

	private static ByteArrayInputStream setInput(Double input) {
		return new ByteArrayInputStream("%f".formatted(input).getBytes());
	}
}

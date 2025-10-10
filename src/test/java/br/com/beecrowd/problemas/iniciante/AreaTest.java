package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.impl.Area;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Area")
class AreaTest {
	private static final String AREA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.AreaArrange";
	private static final String METHOD_SOURCE_ARRANGE_CORRETO = AREA_ARRANGE + "#arrangeCorreto";

	@ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
	@MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
	@DisplayName("Deve retornar o calculo das areas corretamente.")
	void deveCalcularAreasCorretamente(String input, String resultadoEsperado){
		var calcularAreas = new Area();
		System.setIn(setInput(input));
		assertAll("Areas", () -> assertEquals(resultadoEsperado, calcularAreas.execute()));
	}

	private static ByteArrayInputStream setInput(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}
}

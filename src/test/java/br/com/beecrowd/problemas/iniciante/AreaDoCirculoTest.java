package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.impl.AreaDoCirculo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Area do círculo")
public class AreaDoCirculoTest {
	private static final String AREA_DO_CIRCULO_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.AreaDoCirculoArrange";

	@ParameterizedTest(name = "Arrange {index}: {0} = {1}")
	@MethodSource(AREA_DO_CIRCULO_ARRANGE + "#calculaInput")
	@DisplayName("Deve retornar a area do circulo correta.")
	void deveRetornarAreaCirculoCorreta(double in, String esperado){
		AreaDoCirculo test = new AreaDoCirculo();
		System.setIn(getByteArrayInputStream(in));
		String resultado = test.execute();

		assertAll("Area do círculo",
				() -> assertEquals(esperado, resultado, "Resultado deve ser igual ao esperado."));
	}

	private static ByteArrayInputStream getByteArrayInputStream(double a) {
		return new ByteArrayInputStream("""
				%f
				""".formatted(a).getBytes());
	}
}

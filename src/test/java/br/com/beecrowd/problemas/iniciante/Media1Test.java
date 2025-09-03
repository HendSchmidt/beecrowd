package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.impl.Media1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Media 1")
public class Media1Test {
	private static final String MEDIA_1_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.Media1Arrange";

	@ParameterizedTest(name = "Arrange {index}: media de {0},{1} = {2}")
	@MethodSource(MEDIA_1_ARRANGE + "#calculoMediaCorreto")
	@DisplayName("Deve calcular a media correta.")
	void deveCalcularmediaCorreto(Double a, Double b, String esperado) {
		Media1 test = new Media1();
		System.setIn(input(a, b));

		assertAll("Media 1", () -> assertEquals(esperado, test.execute(), "Deve retornar a media correta."));
	}

	private ByteArrayInputStream input(Double a, Double b) {
		return new ByteArrayInputStream("""
				%f
				%f
				""".formatted(a, b).getBytes());
	}
}

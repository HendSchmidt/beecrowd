package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.impl.MediaDois;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Média 2 teste")
public class MediaDoisTest {
	private static final String MEDIA_2_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.Media2Arrange";
	@ParameterizedTest(name = "Arrange {index}: media de {0}, {1}, {2} = {3}")
	@MethodSource(MEDIA_2_ARRANGE + "#mediaPonderadaCorreta")
	void deveRetornarMediaCorreta(Double a, Double b, Double c, String esperado){
		MediaDois test = new MediaDois();
		System.setIn(input(a, b, c));

		assertAll("Media 2", () -> assertEquals(esperado, test.execute(), "Deve retornar a media correta."));
	}

	private ByteArrayInputStream input(Double a, Double b, Double c) {
		return new ByteArrayInputStream("""
				%f
				%f
				%f
				""".formatted(a, b, c).getBytes());
	}
}

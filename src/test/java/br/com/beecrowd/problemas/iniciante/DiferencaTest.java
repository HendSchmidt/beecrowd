package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.impl.Diferenca;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Diferença")
public class DiferencaTest {
	private static final String DIFERENCA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.DiferencaArrange";

	@ParameterizedTest(name = "Arrange {index}: diferença {0}, {1}, {2}, {3} = {4}")
	@MethodSource(DIFERENCA_ARRANGE + "#arrangeDeSucesso")
	@DisplayName("Deve retornar a diferença correta entre os produtos.")
	void deveRetornarDiferencaCorreta(Integer a, Integer b, Integer c, Integer d, String esperado){
		Diferenca test = new Diferenca();
		System.setIn(input(a, b, c, d));

		assertAll("Diferença", () -> assertEquals(esperado, test.execute(), "O retorno deve ser igual ao esperado."));
	}

	private ByteArrayInputStream input(Integer a, Integer b, Integer c, Integer d){
		return new ByteArrayInputStream("""
				%d
				%d
				%d
				%d
				""".formatted(a, b, c, d).getBytes());
	}

}

package br.com.beecrowd.problemas.iniciante;

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
	@MethodSource(AREA_DO_CIRCULO_ARRANGE + "#areaCorreta")
	@DisplayName("Deve retornar a area do circulo correta.")
	void deveRetornarAreaCirculoCorreta(double raio, double esperado){
		AreaDoCirculo test = new AreaDoCirculo();
		double resultado = test.calcularAreaDoCirculo(raio);

		assertAll("Area do círculo", () -> assertEquals(esperado, resultado, "Resultado deve ser igual ao esperado."));
	}

	@ParameterizedTest(name = "Arrange {index}: {0} = {1}")
	@MethodSource(AREA_DO_CIRCULO_ARRANGE + "#calculaInput")
	@DisplayName("Deve retornar o calculo do input correto.")
	void deveRetornarCalculoDoInputCorreto(double raio, String esperado){
		System.setIn(new ByteArrayInputStream("""
				%f
				""".formatted(raio).getBytes()));
		AreaDoCirculo test = new AreaDoCirculo();
		String resultado = test.calculaInput();

		assertAll("Calcula input", () -> assertEquals(esperado, resultado, "Resultado deve ser igual ao esperado."));
	}

	@ParameterizedTest(name = "Arrange {index}: {0} = Mensagem: {1}")
	@MethodSource(AREA_DO_CIRCULO_ARRANGE + "#mensagemCorreta")
	@DisplayName("Deve retornar a mensagem correta.")
	void deveRetornarMensagemCorreta(double raio, String esperado){
		System.setIn(new ByteArrayInputStream("""
				%f
				""".formatted(raio).getBytes()));
		AreaDoCirculo test = new AreaDoCirculo();
		String resultado = test.retornaMensagem();

		assertAll("Calcula input", () -> assertEquals(esperado, resultado, "Resultado deve ser igual ao esperado."));
	}
}

package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.impl.Salario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Salário")
public class SalarioTest {
	private static final String SALARIO_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.SalarioArrange";

	@ParameterizedTest(name = "Arrange {index}: {0}, {1}, {2} -> {3}")
	@MethodSource(SALARIO_ARRANGE + "#arrangeCorreto")
	@DisplayName("Deve calcular o salário de forma correta.")
	void deveCalcularSalarioCorreto(Integer a, Integer b, Double c, String esperado){
		Salario test = new Salario();
		System.setIn(input(a, b, c));

		assertAll("Salario", () -> assertEquals(esperado, test.execute()));
	}

	private ByteArrayInputStream input(Integer a, Integer b, Double c){
		return new ByteArrayInputStream("""
				%d
				%d
				%f
				""".formatted(a, b, c).getBytes());
	}
}

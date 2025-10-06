package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.impl.SalarioComBonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Salario com bonus")
public class SalarioComBonusTest {
	private static final String SALARIO_COM_BONUS_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.SalarioComBonusArrange";

	@ParameterizedTest(name = "Arrange {index}: {0}, {1}, {2} -> {3}")
	@MethodSource(SALARIO_COM_BONUS_ARRANGE + "#arrangeCorreto")
	@DisplayName("Deve calcular o salário de forma correta.")
	void deveRetornarBonusCorreto(String nome, Double a, Double b, String esperado){
		var salarioComBonus = new SalarioComBonus();
		System.setIn(input(nome, a, b));

		assertAll("SalarioComBonus", () -> assertEquals(esperado, salarioComBonus.execute()));
	}

	private ByteArrayInputStream input(String a, Double b, Double c){
		return new ByteArrayInputStream("""
				%s
				%f
				%f
				""".formatted(a, b, c).getBytes());
	}
}

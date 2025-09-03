package br.com.beecrowd.problemas.iniciante;

import br.com.beecrowd.problemas.iniciante.impl.ProdutoSimples;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Produto simples")
public class ProdutoSimplesTest {
	private static final String PRODUTO_SIMPLES_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.ProdutoSimplesArrange";

	@ParameterizedTest(name = "Arrange {index}: {0} * {1} = {2}")
	@MethodSource(PRODUTO_SIMPLES_ARRANGE + "#calculoProdutoSimplesCorreto")
	@DisplayName("Deve retornar produto simples corretamente.")
	void deveRetornarProdutoSimplesCorreto(Integer a, Integer b, String esperado){
		ProdutoSimples test = new ProdutoSimples();
		System.setIn(getByteArrayInputStream(a, b));

		assertAll("Produto simples", () -> assertEquals(test.execute(), esperado, "Deve ser igual ao esperado."));
	}

	private static ByteArrayInputStream getByteArrayInputStream(Integer a, Integer b){
		return new ByteArrayInputStream("""
				%d
				%d
				""".formatted(a,b).getBytes());
	}
}

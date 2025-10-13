package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.beecrowd.problemas.iniciante.impl.GastoDeCombustivel;

@DisplayName("Gasto de Combustível")  
class GastoDeCombustivelTest {
	private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.GastoDeCombustivelArrange";
	private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve realizar o cálculo de gasto de combustível corretamente")
    void deveRealizarOcalculoDeGastoDeCombustivelCorretamente(String input, String resultadoEsperado) {
        var gastoDeCombustivel = new GastoDeCombustivel();
        System.setIn(setInput(input));

        assertAll("Gasto de combustivel", () -> assertEquals(resultadoEsperado ,gastoDeCombustivel.execute()));
    }

    private ByteArrayInputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

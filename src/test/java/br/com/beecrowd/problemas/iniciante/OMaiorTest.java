package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.beecrowd.problemas.iniciante.impl.OMaior;

class OMaiorTest {
    private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.MaiorArrange";
    private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve retornar o mior numero dentre a sequencia fornecida.")
    void deveRetornarOmaiorNumeroDentreASequencia(String input, String resultadoEsperado) {
        var maiorNumero = new OMaior();
        System.setIn(setInput(input));
        assertAll("O maior", () -> assertEquals(resultadoEsperado, maiorNumero.execute()));
    }

    private static ByteArrayInputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}

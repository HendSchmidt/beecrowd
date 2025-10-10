package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.beecrowd.problemas.iniciante.impl.Consumo;

@DisplayName("Consumo")
class ConsumoTest {
    private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.ConsumoArrange";
    private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve retornar consumo correto")
    void deveRetornarConsumoCorreto(String input, String resultadoEsperado) {
        var consumo = new Consumo();
        System.setIn(setInput(input));

        assertAll("Consumo", () -> assertEquals(resultadoEsperado, consumo.execute()));
    }

    private static ByteArrayInputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}

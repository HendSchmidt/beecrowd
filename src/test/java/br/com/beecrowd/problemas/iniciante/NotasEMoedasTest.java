package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.beecrowd.problemas.iniciante.impl.NotasEMoedas;

@DisplayName("Notas e Moedas")
class NotasEMoedasTest {
    private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.NotasEMoedasArrange";
    private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve retornar a contagem de cédulas e moedas corretamente")
    void deveRetornarContagemDeCedulasEmoedasCorretamente(String input, String resultadoEsperado) {
        var notas = new NotasEMoedas();
        System.setIn(setInput(input));

        assertAll("Cedulas e moedas", () -> assertEquals(resultadoEsperado, notas.execute()));
    }

    private ByteArrayInputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

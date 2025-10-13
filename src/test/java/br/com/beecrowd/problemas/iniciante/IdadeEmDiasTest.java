package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.beecrowd.problemas.iniciante.impl.IdadeEmDias;

@DisplayName("Idade em Dias")
public class IdadeEmDiasTest {
    private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.IdadeEmDiasArrange";
    private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve realizazr a conversão de dias em anos corretamente")
    void deveRealizazrAconversaoDeDiasEmAnosCorretamente(String input, String resultadoEsperado) {
        var idadeEmDias = new IdadeEmDias();
        System.setIn(setInput(input));

        assertAll("Idade em dias", () -> assertEquals(resultadoEsperado, idadeEmDias.execute()));
    }

        private ByteArrayInputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

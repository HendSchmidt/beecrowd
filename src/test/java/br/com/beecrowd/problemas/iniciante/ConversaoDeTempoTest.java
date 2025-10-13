package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.beecrowd.problemas.iniciante.impl.ConversaoDeTempo;

@DisplayName("Conversão de Tempo")
public class ConversaoDeTempoTest {
    private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.ConversaoDeTempoArrange";
    private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve retornar a conversão de tempo corretamente")
    void deveRetornarConversaoDeTempoCorreta(String input, String resultadoEsperado) {
        var conversaoDeTempo = new ConversaoDeTempo();
        System.setIn(setInput(input));

        assertAll("Conversão de tempo", () -> assertEquals(resultadoEsperado, conversaoDeTempo.execute()));
    }

    private ByteArrayInputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

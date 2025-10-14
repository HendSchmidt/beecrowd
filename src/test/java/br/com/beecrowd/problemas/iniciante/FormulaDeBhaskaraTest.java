package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Fórmula de Bhaskara")
class FormulaDeBhaskaraTest {
    private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.FormulaDeBhaskaraArrange";
    private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve retornar a mensagem corretamente")
    void deveRetornarMensagemCorretamente(String input, String resultadoEsperado) {
        var formulaDeBhaskara = new br.com.beecrowd.problemas.iniciante.impl.FormulaDeBhaskara();
        System.setIn(setInput(input));

        assertAll("Fórmula de Bhaskara", () -> assertEquals(resultadoEsperado, formulaDeBhaskara.execute()));
    }   

    private ByteArrayInputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

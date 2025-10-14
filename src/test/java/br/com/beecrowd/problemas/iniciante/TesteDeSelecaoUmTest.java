package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.beecrowd.problemas.iniciante.impl.TesteDeSelecaoUm;

@DisplayName("Teste de Seleção 1")
class TesteDeSelecaoUmTest {
    private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.TesteDeSelecaoUmArrange";
    private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve retornar a mensagem corretamente")
    void deveRetornarMensagemCorretamente(String input, String resultadoEsperado) {
        var testeDeSelecaoUm = new TesteDeSelecaoUm();
        System.setIn(setInput(input));

        assertAll("Teste de Seleção 1", () -> assertEquals(resultadoEsperado, testeDeSelecaoUm.execute()));
    }

    private ByteArrayInputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}

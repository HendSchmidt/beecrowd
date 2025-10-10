package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.beecrowd.problemas.iniciante.impl.DistanciaEntreDoisPontos;

@DisplayName("Distancia Entre Dois Pontos")
class DistanciaEntreDoisPontosTest {
    private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.DistanciaEntreDoisPontosArrange";
    private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve retornar distância correta")
    void deveRetornarDistanciaCorreta(String input, String resultadoEsperado) {
        var distanciaCorreta = new DistanciaEntreDoisPontos();
        System.setIn(setInput(input));

        assertAll("Distancia entre dois pontos", () -> assertEquals(resultadoEsperado, distanciaCorreta.execute()));
    }

    private static java.io.ByteArrayInputStream setInput(String input) {
        return new java.io.ByteArrayInputStream(input.getBytes());
    }   
}


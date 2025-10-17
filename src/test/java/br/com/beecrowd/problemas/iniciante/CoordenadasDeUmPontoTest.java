package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.beecrowd.problemas.iniciante.impl.CoordenadasDeUmPonto;

@DisplayName("Coordenadas de um ponto")
class CoordenadasDeUmPontoTest {
    private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.CoordenadasDeUmPontoArrange";
    private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve receber as coordenadas e definir o quadrante correto.")
    void deveReceberCoordenadasEdefinirQuadranteCorreto(String input, String resultadoEsperado){
        var calculoDeQuadrante = new CoordenadasDeUmPonto();
        System.setIn(setInput(input));

        assertAll("Coordenadas", () -> assertEquals(resultadoEsperado, calculoDeQuadrante.execute()));
    }

    private ByteArrayInputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

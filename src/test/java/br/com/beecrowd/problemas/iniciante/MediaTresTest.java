package br.com.beecrowd.problemas.iniciante;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.beecrowd.problemas.iniciante.impl.MediaTres;

@DisplayName("MediaTres")
class MediaTresTest {
    private static final String ESFERA_ARRANGE = "br.com.beecrowd.problemas.iniciante.arrange.MediaTresArrange";
    private static final String METHOD_SOURCE_ARRANGE_CORRETO = ESFERA_ARRANGE + "#arrangeCorreto";

    @ParameterizedTest(name = "Arranjo {index} : {0} -> {1}")
    @MethodSource(METHOD_SOURCE_ARRANGE_CORRETO)
    @DisplayName("Deve calcular a media tres corretamente")
    void deveCalcularMediaTresCorretamente(String input, String resultadoEsperado) {
        Scanner scanner = new Scanner(setInput(input));
        var mediaTres = new MediaTres(scanner);

        assertAll("MediaTres", () -> assertEquals(resultadoEsperado, mediaTres.execute()));
    }

    private ByteArrayInputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

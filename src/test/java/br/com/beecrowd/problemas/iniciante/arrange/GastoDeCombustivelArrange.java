package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class GastoDeCombustivelArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
            Arguments.of("10\n85", "70.833"),
            Arguments.of("2\n92", "15.333"),
            Arguments.of("22\n67", "122.833")
        );
    }   
}

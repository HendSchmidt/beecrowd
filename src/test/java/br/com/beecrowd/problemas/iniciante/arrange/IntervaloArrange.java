package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class IntervaloArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
                Arguments.of("25.01", "Intervalo (25,50]"),
                Arguments.of("25.0", "Intervalo [0,25]"),
                Arguments.of("100.0", "Intervalo (75,100]"),
                Arguments.of("-25.02", "Fora de intervalo")
        );
    }

}

package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class CoordenadasDeUmPontoArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(Arguments.of("4.5 -2.2", "Q4"),
                Arguments.of("0.1 0.1", "Q1"),
                Arguments.of("-2.1 0.1", "Q2"),
                Arguments.of("-5.1 -3.1", "Q3"),
                Arguments.of("0.0 0.0", "Origem"),
                Arguments.of("0.0 0.1", "Eixo Y",
                Arguments.of("0.1 0.0", "Eixo X")));
    }
}

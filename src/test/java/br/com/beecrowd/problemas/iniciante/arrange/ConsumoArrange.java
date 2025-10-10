package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class ConsumoArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
                Arguments.of("500 35.0", "14.286 km/l"),
                Arguments.of("2254 124.4", "18.119 km/l"),
                Arguments.of("4554 464.6", "9.802 km/l"));
    }
}

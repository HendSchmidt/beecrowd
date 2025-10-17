package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class LancheArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
                Arguments.of("3 2", "Total: R$ 10.00"),
                Arguments.of("4 3", "Total: R$ 6.00"),
                Arguments.of("2 3", "Total: R$ 13.50")
        );
    }
}

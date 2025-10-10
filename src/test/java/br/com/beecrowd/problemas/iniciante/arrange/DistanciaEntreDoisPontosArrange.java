package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class DistanciaEntreDoisPontosArrange {
    static Stream<Arguments> arrangeCorreto() {
        String arguments = """
                1.0 7.0
                5.0 9.0
                """;
        String arguments1 = """
                -2.5 0.4
                12.1 7.3
                """;
        String arguments2 = """
                2.5 -0.4
                -12.2 7.0
                """;

        return Stream.of(
                Arguments.of(arguments, "4.4721"),
                Arguments.of(arguments1, "16.1484"),
                Arguments.of(arguments2, "16.4575"));
    }

}

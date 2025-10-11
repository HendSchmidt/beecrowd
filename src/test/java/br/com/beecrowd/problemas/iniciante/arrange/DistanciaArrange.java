package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class DistanciaArrange {
    static Stream<Arguments> arrangeCorreto() {
        String arguments = "30";
        String arguments1 = "110";
        String arguments2 = "7";

        return Stream.of(
                Arguments.of(arguments, "60 minutos"),
                Arguments.of(arguments1, "220 minutos"),
                Arguments.of(arguments2, "14 minutos"));
    }
}

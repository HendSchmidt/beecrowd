package br.com.beecrowd.problemas.iniciante.arrange;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class TrianguloArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(arguments("6.0 4.0 2.0", "Area = 10.0"),
                arguments("8 6 7", "Perimetro = 21.0"),
                arguments("6.0 4.0 2.1", "Perimetro = 12.1"));
    }
}

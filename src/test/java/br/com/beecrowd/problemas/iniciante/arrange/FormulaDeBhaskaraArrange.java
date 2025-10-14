package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class FormulaDeBhaskaraArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
                Arguments.of("10.0 20.1 5.1", "R1 = -0.29788\nR2 = -1.71212"),
                Arguments.of("0.0 20.0 5.0", "Impossivel calcular"),
                Arguments.of("10.3 203.0 5.0", "R1 = -0.02466\nR2 = -19.68408"),
                Arguments.of("10.0 3.0 5.0", "Impossivel calcular"));
    }   

}

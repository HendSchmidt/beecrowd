package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class TesteDeSelecaoUmArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
                Arguments.of( "5\n6\n7\n8", "Valores nao aceitos"),
                Arguments.of("2\n3\n2\n6", "Valores aceitos"));
    }

}

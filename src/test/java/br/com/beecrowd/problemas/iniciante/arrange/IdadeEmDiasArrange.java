package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class IdadeEmDiasArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
                Arguments.of("400", "1 ano(s)\n1 mes(es)\n5 dia(s)"),
                Arguments.of("800", "2 ano(s)\n2 mes(es)\n10 dia(s)"),
                Arguments.of("30", "0 ano(s)\n1 mes(es)\n0 dia(s)")
        );
    }
}

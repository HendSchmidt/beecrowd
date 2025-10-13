package br.com.beecrowd.problemas.iniciante.arrange;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class ConversaoDeTempoArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
                arguments("556", "0:9:16"), arguments("1", "0:0:1"), arguments("140153", "38:55:53"));
    }

}

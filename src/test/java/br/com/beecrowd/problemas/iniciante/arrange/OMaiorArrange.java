package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OMaiorArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
                arguments("7 14 106", "106 eh o maior"),
                arguments("217 14 6", "217 eh o maior"));
    }

}

package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class MediaTresArrange {
    static Stream<Arguments> arrangeCorreto() {
        return Stream.of(
                Arguments.of("2.0 4.0 7.5 8.0\n6.4", "Media: 5.4\nAluno em exame.\nNota do exame: 6.4\nAluno aprovado.\nMedia final: 5.9"),
                Arguments.of("2.0 6.5 4.0 9.0", "Media: 4.8\nAluno reprovado."),
                Arguments.of("9.0 4.0 8.5 9.0", "Media: 7.3\nAluno aprovado.")
        );
    }

}

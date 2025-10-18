package br.com.beecrowd.problemas.iniciante.arrange;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;


public class SortSimplesArrange {
    static Stream<Arguments> arrangeCorreto(){
        return Stream.of(Arguments.of("7 21 -14", "-14\n7\n21\n\n7\n21\n-14"),
        Arguments.of("-14 21 7", "-14\n7\n21\n\n-14\n21\n7"));
    }

}

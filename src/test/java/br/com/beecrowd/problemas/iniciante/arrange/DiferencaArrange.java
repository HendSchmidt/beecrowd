package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DiferencaArrange {
	static Stream<Arguments> arrangeDeSucesso(){
		return Stream.of(arguments(5, 6, 7, 8, "DIFERENCA = -26"), arguments(0, 0, 7, 8, "DIFERENCA = -56"), arguments(5, 6, -7, 8, "DIFERENCA = 86"));
	}
}

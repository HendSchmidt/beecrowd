package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SalarioArrange {
	static Stream<Arguments> arrangeCorreto(){
		return Stream.of(arguments(25, 100, 5.50, "NUMBER = 25\nSALARY = U$ 550.00"),
				arguments(1, 200, 20.50, "NUMBER = 1\nSALARY = U$ 4100.00"),
				arguments(6, 145, 15.55, "NUMBER = 6\nSALARY = U$ 2254.75"));
	}
}

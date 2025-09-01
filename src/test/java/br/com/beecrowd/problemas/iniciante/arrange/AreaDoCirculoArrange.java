package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AreaDoCirculoArrange {
	static Stream<Arguments> calculaInput(){
		return Stream.of(arguments(2.00, "A=12.5664"),
				arguments(100.64, "A=31819.3103"),
				arguments(150.00, "A=70685.7750"));
	}
}

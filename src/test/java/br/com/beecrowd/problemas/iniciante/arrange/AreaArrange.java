package br.com.beecrowd.problemas.iniciante.arrange;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AreaArrange {
	static Stream<Arguments> arrangeCorreto(){
		String arrange = "3.0 4.0 5.2";
		String resultadoEsperado = """
		TRIANGULO: 7.800
		CIRCULO: 84.949
		TRAPEZIO: 18.200
		QUADRADO: 16.000
		RETANGULO: 12.000""";

		String arrange1 = "12.7 10.4 15.2";
		String resultadoEsperado1 = """
		TRIANGULO: 96.520
		CIRCULO: 725.833
		TRAPEZIO: 175.560
		QUADRADO: 108.160
		RETANGULO: 132.080""";

		return Stream.of(arguments(arrange, resultadoEsperado), arguments(arrange1, resultadoEsperado1));
	}
}
